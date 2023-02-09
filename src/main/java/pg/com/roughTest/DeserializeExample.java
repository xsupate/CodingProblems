package pg.com.roughTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeExample {

	public static void main(String[] args) {
		Emp object = null; 
        String filename = "shubham.txt";
		// Deserialization 
        try { 
  
            // Reading the object from a file 
            FileInputStream file = new FileInputStream 
                                         (filename); 
            ObjectInputStream in = new ObjectInputStream 
                                         (file); 
  
            // Method for deserialization of object 
            object = (Emp)in.readObject(); 
  
            in.close(); 
            file.close(); 
            System.out.println("Object has been deserialized\n"
                                + "Data after Deserialization."); 
            printdata(object); 
  
            // System.out.println("z = " + object1.z); 
        } 
  
        catch (IOException ex) { 
            System.out.println("IOException is caught"); 
        } 
  
        catch (ClassNotFoundException ex) { 
            System.out.println("ClassNotFoundException" + 
                                " is caught"); 
        } 
	}
	
	public static void printdata(Emp object1) 
    { 
  
        System.out.println("name = " + object1.name); 
        System.out.println("age = " + object1.age); 
        System.out.println("a = " + object1.a); 
        System.out.println("b = " + Emp.b); 
    } 
}
