//Using two pointers approach
//Time Complexity: O(n)
//Space Complexity: O(1)
package Practise.ArrayAndString;
import java.util.Arrays;

public class TwoSumII {
    public int[] twoSumII(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[] { i + 1, j + 1 };
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    public static void main(String[] args){
    int[] nums = {2,7,11,15};
    int target = 9;
    TwoSumII solution = new TwoSumII();
    System.out.println(Arrays.toString(solution.twoSumII(nums, target)));
  }
}