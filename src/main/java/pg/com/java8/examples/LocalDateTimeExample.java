package pg.com.java8.examples;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Set;

public class LocalDateTimeExample {

	public static void main(String[] args) {
		System.out.println("value of true : " + String.valueOf(true));
		// Current Date
		
		LocalDateTime today = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
		System.out.println("Current DateTime=" + today);

		// Current Date using LocalDate and LocalTime
		today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println("Current DateTime=" + today);

		// Creating LocalDateTime by providing input arguments
		LocalDateTime specificDate = LocalDateTime.of(2014, Month.JANUARY, 1, 10, 10, 30);
		System.out.println("Specific Date=" + specificDate);
		
		Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
		
		//allZoneIds.stream().forEach(s-> System.out.println(s));
		
		// Create LocalDateTime object
        LocalDateTime localdatetime = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
  
        // Print full date
        System.out.println("India Date and time : " + localdatetime);
        
        ZoneId japanZoneId = ZoneId.of("Asia/Tokyo");

        ZoneId americaZoneId = ZoneId.of("US/Samoa");              //America/Los_Angeles");
        
        System.out.println("Japan date and time : " + LocalDateTime.ofInstant(Instant.now(), japanZoneId));
        
        System.out.println("Japan date and time : " + LocalDateTime.now(japanZoneId));
        
        System.out.println("americaZoneId date and time : " + LocalDateTime.now(americaZoneId));
	}

}
