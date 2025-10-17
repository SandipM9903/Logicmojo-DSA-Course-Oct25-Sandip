/*
Given an array of distinct elements, which is formed from some places rotation of a sorted array, find if a given element is present in the array or not.
Note: Try to do it in O(logn) runtime complexity

Input Format

First line is the length of the array
Second line is the target element
Next line is the elements of the array

Constraints

1 <= arr.length <= 5000
-104 <= arr[i] <= 104
All values of arr are unique.
arr is an ascending array that is possibly rotated.
-104 <= target <= 104

Output Format

Return the index of target if it is in array, or -1 if it is not in array.

Sample Input 0

7
0
4 5 6 7 0 1 2
Sample Output 0

4 
*/

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Determine which side is properly sorted
            if (nums[left] <= nums[mid]) { // Left side is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target is in the left side
                } else {
                    left = mid + 1; // Target is in the right side
                }
            } else { // Right side is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Target is in the right side
                } else {
                    right = mid - 1; // Target is in the left side
                }
            }
        }

        return -1; // Target not found
    }
}