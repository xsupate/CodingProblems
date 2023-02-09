package pg.com.roughTest;

import java.io.Serializable;

public class EnumTest {

	public static void main(String[] args) {
		Color c1 = Color.RED;
		System.out.println(c1);
        System.out.println(Color.valueOf("RED"));
        
        for(Color c: Color.values()) {
        	System.out.println(c + " " + c.ordinal());
        }
	}

}

enum Color implements Serializable
{
    YELLOW, RED, GREEN, BLUE;
	
	String name;
	
	Color(String name) {
		this.name = name;
	}
	
    Color() {
		
	}
    
    protected Color readResolve()
    {
        return YELLOW;
    }
}