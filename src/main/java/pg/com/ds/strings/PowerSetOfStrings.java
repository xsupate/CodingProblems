package pg.com.ds.strings;

public class PowerSetOfStrings {

	public static void main(String[] args) {
		String str = "abc";
		//printPowerSet(str);
		permutation(str);
	}

	public static void printPowerSet(String str) {
		printPowerSet(str, 0, "");
	}

	private static void printPowerSet(String str, int i, String temp) {
		if(i == str.length()) {
			System.out.print(temp + " ");
		}
		
		if(i >= str.length())
			return;
		
		printPowerSet(str, i+1, temp+str.charAt(i));
		printPowerSet(str, i+1, temp);
	}
	
	public static void permutation(String str) {
		permutation(str, 0, str.length()-1);
	}

	private static void permutation(String str, int l, int r) {
		if(l == r) {
			System.out.print(str + " ");
			return;
		}
		
		for(int i = l; i <= r; i++) {
			str = swap(str, i,l);
			permutation(str, i+1, r);
			str = swap(str, i,l);
		}
	}

	private static String swap(String str, int i, int j) {
		char[] c = str.toCharArray();

		// Replace with a "swap" function, if desired:
		char temp = c[0];
		c[0] = c[1];
		c[1] = temp;

		return new String(c);
	}
}
