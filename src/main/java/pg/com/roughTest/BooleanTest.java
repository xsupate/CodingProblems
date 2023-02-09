package pg.com.roughTest;

public class BooleanTest {

	public static void main(String[] args) {
		System.out.println(" " + (true && !bool(true)));
        System.out.println(bool(null)); //(line 17)
        System.out.println(bool(false));
	}

	public static Boolean bool(Boolean param){
        if(param == true){   // (line 5)
            return true;
        }else if(param == false){
            return false;
        }
        return true;

    }
}
