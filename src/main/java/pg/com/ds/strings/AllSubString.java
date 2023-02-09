package pg.com.ds.strings;

public class AllSubString {

	public static void main(String[] args) {
		String str = "abc";
        printAllSubString(str, "");
	}

	private static void printAllSubString(String str, String output) {
		if(str.isEmpty()) {
			System.out.print(" " + output);
			return;
		}
		
		printAllSubString(str.substring(1), output);
		printAllSubString(str.substring(1), output+str.charAt(0));
	}

}
