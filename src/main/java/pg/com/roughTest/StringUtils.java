package pg.com.roughTest;

import java.util.Scanner;

public class StringUtils {
	static {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		System.out.println("A : " + A);
		System.out.println("B : " + B);
		scan.close();
	}

	public static void main(String[] args) {
		
    }
	
	
    public static boolean isAlphbet(char ch){
        if((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)){
            return true;
        }
        return false;
    }

	public static String reverse(String str){
        if(str.length() == 1){
            return str;
        }
        return str.substring(str.length()-1)+reverse(str.substring(0, str.length()-1));
    }
}
