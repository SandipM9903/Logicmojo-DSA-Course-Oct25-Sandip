// New file
//[1,2,1,0,2,1,0,2]

import java.util.*;

public class SortColor{
  public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
        for(int i : nums){
          System.out.println(i);
        }
    }
    public static void main(String[] args){
      SortColor solution = new SortColor();
      int[] nums = {1,2,1,0,2,1,0,2};
      solution.sortColors(nums);
    }
}