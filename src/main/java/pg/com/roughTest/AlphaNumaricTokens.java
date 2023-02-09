package pg.com.roughTest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

public class AlphaNumaricTokens {

	public static void main(String[] args) {
         System.out.println("Token " + getUniqueToken("xyz"));
	}

	public static String getUniqueToken(String userId) {
		long timestamp = new Date().getTime();
		InetAddress ip=null;
		try {
			ip = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		String token = String.valueOf(timestamp)+ip;
		return token;
	}
}
