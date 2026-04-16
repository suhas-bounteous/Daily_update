import java.util.Arrays;

public class MaxSubarray {

    public static int maxSubArray(int[] nums) {
        // Initialize with the first element
        int maxSoFar = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decision: Start a new subarray at i, or extend the existing one?
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            
            // Update the global maximum if the current streak is better
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        
        int result = maxSubArray(nums);
        
        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Maximum Subarray Sum: " + result);
    }
}