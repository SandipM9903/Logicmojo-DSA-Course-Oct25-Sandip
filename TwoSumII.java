// New file
import java.util.*;

public class TwoSumII{
  public int[] twoSum(int[] nums, int target) {
    int i = 0;
    int j = nums.length - 1;

    while(i<j){
      int sum = nums[i] + nums[j];
      if(sum == target){
        return new int[]{i+1, j+1};
      }
      else if(sum < target){
        i++;
      }
      else{
        j--;
      }
    }
    return null;
  }
  public static void main(String[] args){
    int[] nums = {2,7,11,15};
    int target = 9;
    TwoSumII solution = new TwoSumII();
    System.out.println(Arrays.toString(solution.twoSum(nums, target)));
  }

}