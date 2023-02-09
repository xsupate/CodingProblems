package pg.com.java8.examples;

import java.time.LocalTime;
import java.time.ZoneId;

public class LocalTimeExample {

	public static void main(String[] args) {
		LocalTime localTime = LocalTime.now();

		System.out.println("Local time now " + localTime);

		// Creating LocalTime by providing input arguments
		LocalTime specificTime = LocalTime.of(23, 20, 25, 40);
		System.out.println("Specific Time of Day=" + specificTime);

		// Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
		LocalTime timeKolkata = LocalTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Current Time in IST=" + timeKolkata);
	}

}
