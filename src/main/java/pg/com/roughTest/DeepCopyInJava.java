package pg.com.roughTest;

public class DeepCopyInJava {

	public static void main(String[] args) {
		    NewCourse science = new NewCourse("Physics", "Chemistry", "Biology");
		    NewStudent student1 = new NewStudent(111, "John", science);
		    NewStudent student2 = null;
	        try {
	            //Creating a clone of student1 and assigning it to student2
	            student2 = (NewStudent) student1.clone();
	        }
	        catch (CloneNotSupportedException e) {
	            e.printStackTrace();
	        }
	 
	        //Printing the subject3 of 'student1'
	        System.out.println(student1.course.subject3);         //Output : Biology
	 
	        //Changing the subject3 of 'student2'
	        student2.course.subject3 = "Maths";
	 
	        //This change will not be reflected in original student 'student1'
	        System.out.println(student1.course.subject3);       //Output : Biology
	    }
}

class NewCourse implements Cloneable {
    String subject1;
    String subject2;
    String subject3;
    public NewCourse(String sub1, String sub2, String sub3) {
        this.subject1 = sub1;
        this.subject2 = sub2;
        this.subject3 = sub3;
    }
 
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class NewStudent implements Cloneable {
    int id;
    String name;
    NewCourse course;
 
    public NewStudent(int id, String name, NewCourse course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }
 
    //Overriding clone() method to create a deep copy of an object.
    protected Object clone() throws CloneNotSupportedException {
        NewStudent student = (NewStudent) super.clone();
        student.course = (NewCourse) course.clone();
        return student;
    }
}