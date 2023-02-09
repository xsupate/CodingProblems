package pg.com.ds.arrays;

public class ProductExceptSelf {

	public static void main(String[] args) {
		int[] nums = {-1,1,0,-3,3};
        for(int i : productExceptSelf(nums))
        	System.out.print(i + " ");
	}

	public static int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
        int[] rp = new int[nums.length];
        int prod = 1;
        for(int i = nums.length-1; i > 0; i--) {
        	prod = prod * nums[i];
        	rp[i] = prod;
        }
        
        prod = 1;
        for(int i = 0; i < nums.length-1; i++) {
        	int lp = prod;
        	int rProd = rp[i+1];
        	res[i] = lp*rProd;
        	prod *= nums[i];
        }
        
        res[nums.length-1] = prod;
        
        return res;
    }
}
