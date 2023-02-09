package pg.com.ds.arrays;

public class RemoveDuplicatesInSortedArray {

	public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println("Unique elemnts " + removeDuplicates(nums));
        for(int num : nums)
        	System.out.print(" " + num);
	}

	public static int removeDuplicates(int[] nums) {
        int i = 0; 
        for(int j = i+1; j < nums.length;j++){
            if(nums[i] == nums[j]){
                continue;
            }else{
            	i++;
                nums[i] = nums[j];
            }
        }
        
        return i+1;
    }
}
