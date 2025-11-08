public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int n = height.length;

        // Brute Force :::: O(n^2)
        // for(int i=0; i<n; i++){ //For left-boundary
        // for(int j=i+1; j<n; j++){ //For right-boundary
        // int width = j-i;
        // int minHeight = Math.min(height[i], height[j]);
        // int area = (width * minHeight);
        // maxWater = Math.max(maxWater, area);
        // }
        // }

        // Omptimal Solution 2-pointers :::: O(n)
        int leftPointer = 0;
        int rightPointer = n - 1;

        while (leftPointer < rightPointer) {
            int width = rightPointer - leftPointer;
            int minHeight = Math.min(height[leftPointer], height[rightPointer]);
            int currentWater = width * minHeight;
            maxWater = Math.max(maxWater, currentWater);

            if (height[leftPointer] < height[rightPointer]) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solu = new ContainerWithMostWater();
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        System.out.println(solu.maxArea(height));
    }
}