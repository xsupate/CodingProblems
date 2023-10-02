package pg.com.roughTest;

import java.util.Arrays;
import java.util.List;

public class IntegerTest {

	public static void main(String[] args) {
		Integer i1 = 128;
		Integer i2 = 128;
		if(i1 == i2) {
			System.out.println("Both i1 and i1 are equal");
		}else {
			System.out.println("Both i1 and i1 are not equal");
		}
		
		List<String> list = Arrays.asList("Sunil", "Kumar", "Patel");
		System.out.println("Value of list " + list);
	}
}
