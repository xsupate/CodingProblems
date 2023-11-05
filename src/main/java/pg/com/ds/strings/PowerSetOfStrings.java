package pg.com.ds.strings;

public class PowerSetOfStrings {
	static int i = 0;

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
			System.out.print("{" + temp + "}" + " ");
		}
		
		if(i >= str.length())
			return;
		
		printPowerSet(str, i+1, temp+str.charAt(i));
		printPowerSet(str, i+1, temp);
	}
	
	public static void permutation(String str) {
		permutation(str, 0, str.length());
	}

	private static void permutation(String str, int l, int r) {
		if(l == r-1) {
			System.out.print(str + " ");
		}else {
			for(int i = l; i < r; i++) {
				str = swapString(str,l, i);
				permutation(str, l+1, r);
				str = swapString(str,l, i);
			}
		}
	}

	public static String swapString(String a, int i, int j) {
		char[] b = a.toCharArray();
		char ch;
		ch = b[i];
		b[i] = b[j];
		b[j] = ch;
		return String.valueOf(b);
	}
}
