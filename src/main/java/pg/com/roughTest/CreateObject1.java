package pg.com.roughTest;

public class CreateObject1 {

	public static void main(String[] args) {
		try {
			Class claz = Class.forName("pg.com.roughTest.DemoClass");
			DemoClass obj = (DemoClass)claz.newInstance();
			System.out.println("name is " + obj.name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
