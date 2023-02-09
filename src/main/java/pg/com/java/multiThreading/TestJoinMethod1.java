package pg.com.java.multiThreading;

public class TestJoinMethod1 extends Thread{ 
	 String name;
	 
	 public TestJoinMethod1(String name) {
		 this.name = name;
		 super.setName(name);
	 }
	 public void run(){  
		  for(int i=1;i<=5;i++){  
		   try{  
		    Thread.sleep(500);  
		   }catch(Exception e){
			   System.out.println(e);
		   }  
		    System.out.println(this.getName() + " : " + i);  
		  }  
		 }  
		public static void main(String args[]){  
		 TestJoinMethod1 t1=new TestJoinMethod1("Thread t1");  
		 TestJoinMethod1 t2=new TestJoinMethod1("Thread t2");  
		 TestJoinMethod1 t3=new TestJoinMethod1("Thread t3");  
		 t1.start();
		 
		 try{  
		  t1.join();  
		 }catch(Exception e){System.out.println(e);}  
		  
		 t2.start();  
		 t3.start();  
		 }  
		}  