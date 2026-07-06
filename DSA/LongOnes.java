
class LongOnes {
    // Function to find the longest subarray with at most k zero flips
    public int longestOnes(int[] nums, int k) {

        // Left pointer for the window
        int left = 0;

        // Counter for zeros in the window
        int zeros = 0;

        // Variable to store maximum window length
        int maxLen = 0;

        // Right pointer expands the window
        for (int right = 0; right < nums.length; right++) {

            // If element is zero, increase the zero count
            if (nums[right] == 0) {
                zeros++;
            }

            // If zero count exceeds k, shrink the window
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                // Move left pointer
                left++; 
            }

            // Update the max length of the valid window
            maxLen = Math.max(maxLen, right - left + 1);
        }

        // Return the result
        return maxLen;
    }
}

// Driver code
// public class Main {
//     public static void main(String[] args) {
//         Solution sol = new Solution();

//         int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
//         int k = 2;

//         // Output the result
//         System.out.println(sol.longestOnes(nums, k));
//     }
// }
