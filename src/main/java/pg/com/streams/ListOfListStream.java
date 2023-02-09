package pg.com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfListStream {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();List<String> list2 = new ArrayList<>();List<String> list3 = new ArrayList<>();
		
		list1.add("col00");list1.add("col01");list1.add("col02");list1.add("col03");list1.add("col04");
		
		list2.add("col10");list2.add("col11");list2.add("col12");list2.add("col13");list2.add("col14");
		
		list3.add("col20");list3.add("col21");list3.add("col22");list3.add("col23");list3.add("col24");
		
		if(list2.contains(null)) {
			System.out.println("in null block");
		}else {
			System.out.println("Not in null block");
		}
		
		List<List<String>> tableData = new ArrayList<List<String>>();
		tableData.add(list1);tableData.add(list2);tableData.add(list3);
		
		List<String> updatedList1 = list1.stream().map(data -> 
		data.contains("3")?data.concat("pass") : data).collect(Collectors.toList());
			
		updatedList1.stream().forEach(s -> System.out.println(s));	
		
		List<List<String>> updatedDatas =  tableData.stream().map(listValue -> listValue.stream().map(
		data -> {
			
			String[] values = data.split(",");
			Arrays.stream(values).map(str -> str.concat("1234")).collect(Collectors.toList());
		    
			return data.contains("3") ? data.concat("pass") : data;
		}).collect(Collectors.toList())).collect(Collectors.toList());
		
	}

}
