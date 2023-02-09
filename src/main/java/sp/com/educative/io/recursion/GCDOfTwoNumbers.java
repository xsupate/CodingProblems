package sp.com.educative.io.recursion;

/**
 * The GCD of two integers is the largest integer that can fully divide both numbers, without a remainder.
 * 
 * @author sunipate
 *
 */
public class GCDOfTwoNumbers {

	public static void main(String[] args) {
        int num1 = 23;
        int num2 = 71;
        System.out.println("GCD of " + num1 + " and " + num2 + " is " + gcdOfTwoNumbers(num1, num2));
	}

	public static int gcdOfTwoNumbers(int num1, int num2) {
		if(num1 == num2)
			return num1;
		
		if(num1 > num2)
			return gcdOfTwoNumbers(num1-num2, num2);
		else
			return gcdOfTwoNumbers(num1, num2-num1);
	}
}
