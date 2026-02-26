package Daily_update.DSA;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solver = new ContainerWithMostWater();

        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Test Case 1 Result: " + solver.maxArea(height1));

        int[] height2 = {1, 1};
        System.out.println("Test Case 2 Result: " + solver.maxArea(height2));

        int[] height3 = {4, 3, 2, 1, 4};
        System.out.println("Test Case 3 Result: " + solver.maxArea(height3));
    }
}
