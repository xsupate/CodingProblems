package pg.com.java.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class GoupingByExp1 {
	static List<Employee> empList;
	
	static {
	    empList = Arrays.asList(new Employee(1001, "male", "Suresh", "sales", 10000)
				, new Employee(1002, "female", "Seema", "HR", 11000)
				, new Employee(1003, "male", "Ramesh", "sales", 11000)
				, new Employee(1004, "male", "Ramm", "sales", 11000)
				, new Employee(1005, "female", "Sunita", "HR", 14000)
				, new Employee(1006, "female", "Reema", "HR", 11000)
				, new Employee(1007, "female", "Pooja", "HR", 12000));
	}

	public static void main(String[] args) {
		 Map<String, List<Employee>> map = empList.stream().collect(Collectors.groupingBy(s-> s.getGender()));
         System.out.println(map);
         
         Map<String, List<String>> namesmap = empList.stream().collect(Collectors.groupingBy(s-> s.getGender(), 
        		 Collectors.mapping(emp->emp.getName(), Collectors.toList())));
         System.out.println(namesmap);
         
         Map<String, Employee> highestSalaryByDepartment = empList.stream()
                 .collect(Collectors.toMap(Employee::getDeptName, e -> e,
                         BinaryOperator.maxBy(Comparator.comparingDouble(Employee::getSalary))));

         highestSalaryByDepartment.forEach((department, employee) ->
                 System.out.println("Department: " + department + ", Highest Salary Employee: " + employee));
         
         
         Map<String, Employee> highestSalaryByDepartment1 = empList.stream()
                 .collect(Collectors.groupingBy(Employee::getDeptName,
                         Collectors.collectingAndThen(
                                 Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)),
                                 Optional::get
                         )));

         Map<String, Employee> highestSalaryByGender = empList.stream()
                 .collect(Collectors.groupingBy(Employee::getGender,
                         Collectors.collectingAndThen(
                                 Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                 Optional::get
                         )));

         highestSalaryByDepartment1.forEach((department, employee) ->
                 System.out.println("Department: " + department + ", Highest Salary Employee: " + employee));

         highestSalaryByGender.forEach((gender, employee) ->
                 System.out.println("Gender: " + gender + ", Highest Salary Employee: " + employee));
     }

}

class Employee{
	private int id;
	
	private String gender;
	
	private String name;
	
	private String deptName;
	
	private int salary;
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", gender=" + gender + ", name=" + name + ", deptName=" + deptName + ", salary="
				+ salary + "]";
	}

	public Employee(int id, String gender, String name, String deptName, int salary) {
		super();
		this.id = id;
		this.gender = gender;
		this.name = name;
		this.deptName = deptName;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}