public class MaxSumSubarr {

    public static int findMaxSumSubarray(int k, int[] nums) {
        if (nums == null || nums.length < k) {
            return 0;
        }

        int windowSum = 0;
        int maxSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            // 1. Add the next element to the window
            windowSum += nums[windowEnd]; 

            // 2. Once we hit size 'k', start sliding
            if (windowEnd >= k - 1) {
                // Update the maximum sum seen so far
                maxSum = Math.max(maxSum, windowSum);

                // 3. Subtract the element going out
                windowSum -= nums[windowStart];

                // 4. Move the window start forward
                windowStart++;
            }
        }

        return maxSum;
    }

    // Main method to test the code
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 1, 3, 2};
        int k = 3;
        
        int result = findMaxSumSubarray(k, nums);
        
        System.out.println("Array: [2, 1, 5, 1, 3, 2], k = 3");
        System.out.println("Maximum sum of subarray of size k: " + result);
        // Expected Output: 9 (because [5, 1, 3] is the max sum)
    }
} 
