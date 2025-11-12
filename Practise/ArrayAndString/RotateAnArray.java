package Practise.ArrayAndString;

public class RotateAnArray {
    // Brute force
    // public void rotate(int[] nums, int k){
    // int n = nums.length;
    // int[] res = new int[n];

    // for(int i=0; i<n; i++){
    // int j = (i+k)%n;
    // res[j] = nums[i];
    // }
    // for(int i=0; i<n; i++){
    // nums[i] = res[i];
    // }
    // }
    public void rotate(int[] nums, int k){
        int n = nums.length;
        if(n == 1) return;
        k%=n;
        //First reverse the array
        reverse(nums, 0, n-1);

        //Second reverse left side of K
        reverse(nums, 0, k-1);

        //Third reverse right side of K
        reverse(nums, k, n-1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RotateAnArray solu = new RotateAnArray();
        int[] nums = { 1,2,3,4,5,6,7};
        for(int i=0; i<nums.length; i++){
        System.out.print(nums[i] + " ");
        }
        System.out.println();
        solu.rotate(nums, 3);
        for(int i=0; i<nums.length; i++){
        System.out.print(nums[i] + " ");
        }
    }
}
