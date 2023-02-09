package pg.com.ds.arrays;

/*
 Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
 n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). 
 Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

 Notice that you may not slant the container.
 Example 1:
 Input: height = [1,8,6,2,5,4,8,3,7]
 Output: 49
 Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. 
 In this case, the max area of water (blue section) the container can contain is 49.
*/

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println("Maximum water is " + maxArea(height));
	}

	public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int max = 0;
        while(start < end){
            int lh = height[start];
            int rh = height[end];
            int minH = Math.min(lh,rh);
            max = Math.max(max, minH*(end-start));
            if(lh < rh){
               start++;  
            }
            else{
                end--;
            }
        }     
        return max;
    }
}
