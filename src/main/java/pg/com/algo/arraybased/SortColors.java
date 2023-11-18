package pg.com.algo.arraybased;

public class SortColors {

	public static void main(String[] args) {
		int nums[] = {2,1,0,0,2,2,1,0,0,1};
		sortColors(nums);
		for(int i : nums)
			System.out.print(i+", ");
	}

	public static void sortColors(int[] nums) {
        int zeroStart = 0, oneStart = 0, twoStart=nums.length-1;
        while(oneStart <= twoStart){
            if(nums[oneStart] == 0){
               swap(nums,oneStart,zeroStart);
               zeroStart++;
               oneStart++; 
            }else if(nums[oneStart] == 2){
                swap(nums,oneStart,twoStart);
                twoStart--;
            }else  if(nums[oneStart] == 1){
               oneStart++;
            }
        }
    }
    
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
