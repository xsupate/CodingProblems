package sp.com.educative.io.recursion;

public class DecimalToBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int decimalToBinary(int decimalNum) {
		if (decimalNum == 0) {
			return 0;
		} else {
			return (decimalNum % 2 + 10 * decimalToBinary(decimalNum / 2));
		}
	}

}
