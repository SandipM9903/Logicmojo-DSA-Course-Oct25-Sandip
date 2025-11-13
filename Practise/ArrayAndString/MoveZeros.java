package Practise.ArrayAndString;

public class MoveZeros{

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i=0;
        for(int j=0; j<n; j++){
            if(nums[j]!=0){
                swap(nums, i, j);
                i++;
            }
        }
    }

    public void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args) {
        MoveZeros solu = new MoveZeros();
        // int[] nums = {1,2,3,4,5,6,7};
        // solu.swap(nums, 1, 6);
        // for(int i : nums){
        //     System.out.print(i + " ");
        // }

        int[] nums = {1,2,0,12,0,4};
        solu.moveZeroes(nums);
        for(int n : nums){
            System.out.print(n + " ");
        }
    }
}