package Practise.ArrayAndString;

import java.util.Arrays;

public class MissingNumber {
    // This is one way :
    public int missingNo(int[] nums) {
        int n = nums.length;
        // for finding the sum of an array 0 to n
        int sum1 = n * (n + 1) / 2;
        // for finding the sum of array like 1,2,3 except 0
        int sum2 = Arrays.stream(nums).sum();

        return sum1 - sum2;
    }

    // other way XOR operation
    // XOR Missing Number Logic (Quick Reminder)

    // 1. Why XOR?
    // x ^ x = 0 (same numbers cancel)
    // x ^ 0 = x (keeps the number)
    // So XOR removes pairs and leaves the missing number.

    // 2. What two sets are we comparing?
    // - Actual array: nums[]
    // - Expected numbers: 0 to n
    // All matching values cancel out.

    // 3. Why use: res = res ^ i ^ nums[i] ?
    // - 'i' is the expected number (0,1,2,...)
    // - nums[i] is the actual number at that index
    // One loop compares both sets at the same time.

    // 4. Why XOR with n at the end?
    // - loop covers 0..n-1
    // - the last expected number is n
    // - so final answer = res ^ n

    // 5. When NOT to use 'i'?
    // If array values do NOT match index pattern (like 1,2,3,5),
    // then 'i' is not part of the expected set.
    // Only XOR the values in that case.

    // Summary:
    // XOR cancels duplicates and leaves the missing number.
    // Use 'i' only when expected numbers are 0..n.

    public int missingNo2(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = res ^ i ^ nums[i];
        }
        return res ^ n;
    }

    public static void main(String[] args) {
        MissingNumber solu = new MissingNumber();
        int[] nums = { 0, 2, 3 };
        System.out.println(solu.missingNo2(nums));
    }
}
