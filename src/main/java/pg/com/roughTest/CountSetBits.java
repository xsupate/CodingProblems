package pg.com.roughTest;

import java.util.ArrayList;
import java.util.List;

public class CountSetBits {

	public static void main(String[] args) {
        System.out.println("No of setBits is " + countSetBitsUtil(2)); 
	}

	static int countSetBitsUtil( int x)
    {
        if (x <= 0)
            return 0;
        return (x % 2 == 0 ? 0 : 1) +
               countSetBitsUtil(x / 2);
    }
}
