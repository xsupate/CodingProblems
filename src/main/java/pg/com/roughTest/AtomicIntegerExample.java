package pg.com.roughTest;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

	public static void main(String[] args) {
		AtomicInteger res = new AtomicInteger(Integer.MIN_VALUE);
		res.set(12345);
		System.out.println(res.get());
	}

}
