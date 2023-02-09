package pg.com.roughTest;

public class TrickyHacks {
	public static int base;

	public static void main(String[] args) {
		printNum(5);
		printNum(10);
		printFromA2B(5,10);
	}

	/**
	 * Program to print 10 if input is 5 and return 5 if input is 10 without using
	 * if else or any conditional block
	 */
	public static void printNum(int num) {
		int[] nums = { 5, 10 };
		System.out.println(nums[num % 2]);
	}
	
	/**
	 * Programs to print range between a and b without using any loop
	 */
	public static void printFromA2B(int a, int b) {
		base = a;
		printNumber(b);
	}

	private static void printNumber(int b) {
		if(b < base) {
			return;
		}
		printNumber(b-1);
		System.out.print(b + " ");
	}
}
