package pg.com.java8.examples;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class LocalDateExample {

	public static void main(String[] args) throws ParseException {
	   LocalDate localDate = LocalDate.now();
       System.out.println("Local Date now " + localDate);
       
       localDate = LocalDate.of(2000, Month.FEBRUARY, 29);
       System.out.println("Specific Date now " + localDate);
       
       Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2021-06-14");
       System.out.println("date is " + date);
       
       LocalDateTime visitDate = LocalDateTime.ofInstant(date.toInstant(), ZoneId.of("UTC"));
       System.out.println("visitDate in UTC " + visitDate);
       
       ZonedDateTime visitDt = null; 
		
	   visitDt = ZonedDateTime.of(visitDate.getYear(), visitDate.getMonthValue(),
				visitDate.getDayOfMonth(), visitDate.getHour(),
				visitDate.getMinute(), visitDate.getSecond(),
				visitDate.getNano(), ZoneId.systemDefault());
		
		LocalDateTime visitDateWithBeforeWindow = visitDt.toLocalDateTime();
		System.out.println("visitDateWithBeforeWindow " + visitDateWithBeforeWindow);
	}

}
