package pg.com.opps;

public class MultupleInterfaceImpl implements A1, A2{
     public static void main(String[] args) {
    	 MultupleInterfaceImpl obj = new MultupleInterfaceImpl();
    	 //System.out.println(obj.i); // The field obj.i is ambiguous
     }
}


interface A1{
	public int i = 10;
}

interface A2{
	public int i = 10;
}