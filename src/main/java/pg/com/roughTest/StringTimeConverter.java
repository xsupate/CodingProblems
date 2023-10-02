package pg.com.roughTest;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class StringTimeConverter {

	public static void main(String[] args) {
		//String dateTime = "/Date(1690520400000-0500)/";
		String dateTime = "/Date(2208970800000-0500)/";
		String miliSecondStr = dateTime.substring(dateTime.indexOf("(")+1,  dateTime.indexOf("-"));
    	String timeZoneValue = dateTime.substring(dateTime.indexOf("-"), dateTime.indexOf(")"));
    	
    	
    	
    	System.out.println("miliSecondStr " + miliSecondStr);
    	System.out.println("timeZoneValue " + timeZoneValue);
    	
    	OffsetDateTime dateTime1 = Instant.ofEpochMilli(Long.valueOf(miliSecondStr)).atOffset(ZoneOffset.of(timeZoneValue));
    	System.out.println("dateTime1 " + dateTime1.toString());
    	
    	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	System.out.println("formated date " + fmt.format(dateTime1));
    	
    	
    	System.out.println(" " + dateTime1.toLocalDateTime());
	}

}
