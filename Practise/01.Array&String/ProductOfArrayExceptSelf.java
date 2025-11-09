import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] product(int[] nums) {
        int[] res = new int[nums.length];
        int n = nums.length;
        // int[] prefix = new int[nums.length];
        // int[] suffix = new int[nums.length];

        // //Finding Prefix
        // prefix[0] = 1;
        // for(int i=1; i<nums.length; i++){
        // prefix[i] = prefix[i-1] * nums[i-1];
        // }

        // //Finding Suffix
        // suffix[nums.length-1] = 1;
        // for(int i=nums.length-2; i>=0; i--){
        // suffix[i] = suffix[i+1] * nums[i+1];
        // }

        // //For finding product of array except itself = prefix * suffix
        // for(int i=0; i<nums.length; i++){
        // res[i] = prefix[i] * suffix[i];
        // }

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // Step 2: Multiply suffix product in reverse
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * suffix;
            suffix *= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(solution.product(nums)));
    }
}