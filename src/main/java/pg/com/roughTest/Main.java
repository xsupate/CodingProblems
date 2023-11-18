package pg.com.roughTest;

import pg.com.designpatterns.Phone;

class Test 
{ 
    int x; 
    Test(int i) { x = i; } 
    Test()      { x = 0; } 
} 

public class Main {
	public static void main(String[] args) 
    { 
       //System.out.println("Is buddyStrings : " + thirdMax(new int[] {2,2,3,1}));
		
		Integer newInt = new Integer(1);
		if(newInt.equals(1)) {
			System.out.println("newInt is equal to 1");
		}
       
       System.out.println( "remainder " + (-13)%10);
    } 
  
	public static int thirdMax(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        for(int i : nums){
            if(i > firstMax){
                thirdMax = secMax;
                secMax = firstMax;
                firstMax = i;
            }else if(i < firstMax && i > secMax){
                thirdMax = secMax;
                secMax = i;
            }else if(i < secMax && i > thirdMax){
                thirdMax = i;
            }
        }
        if((nums.length < 3)){
                return firstMax;
        }
        
        return thirdMax;
    }
}
