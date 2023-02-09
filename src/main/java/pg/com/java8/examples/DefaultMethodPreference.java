package pg.com.java8.examples;

//This is called Third rule display method of class A gets priority over interface method 
public class DefaultMethodPreference extends A implements I, J{
  
	public static void main(String[] args) {
		DefaultMethodPreference obj = new DefaultMethodPreference();
		obj.display();

	}

}

interface I{
	default void display() {
		System.out.println("I");
	}
}

interface J{
	default void display() {
		System.out.println("J");
	}
}

class A{
	public void display() {
		System.out.println("A");
	}
}