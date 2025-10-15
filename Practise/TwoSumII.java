//Using two pointers approach
//Time Complexity: O(n)
//Space Complexity: O(1)

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
}