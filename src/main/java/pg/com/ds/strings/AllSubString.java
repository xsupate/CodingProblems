package pg.com.ds.strings;

import java.util.ArrayList;
import java.util.List;

public class AllSubString {

	public static void main(String[] args) {
		String str = "abc";
        //printAllSubString(str, "");
        
        printAllSubString1(0, str, new ArrayList<Character>());
	}

	private static void printAllSubString1(int i, String str, ArrayList<Character> arrayList) {
		if(i == str.length()) {
			if(!arrayList.isEmpty()) {
				List<Character> list = new ArrayList<>(arrayList);
				System.out.println(String.valueOf(list));
			}
			return;
		}
		
		arrayList.add(str.charAt(i));
		printAllSubString1(i+1, str, arrayList);
		arrayList.remove(arrayList.size()-1);
		printAllSubString1(i+1, str, arrayList);
	}

	private static void printAllSubString(String str, String output) {
		if(str.isEmpty()) {
			System.out.print(" " + output);
			return;
		}
		
		printAllSubString(str.substring(1), output);
		printAllSubString(str.substring(1), output + str.charAt(0));
	}
	
	

}
