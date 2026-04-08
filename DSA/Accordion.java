class Accordion {
    public int minSubArrayLen(int target, int[] nums) {
        // 'left' is the start of our window
        int left = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        // 'right' expands the window
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            // While the window meets the condition, try to shrink it from the left
            while (currentSum >= target) {
                // Calculate window size: (right - left + 1)
                minLength = Math.min(minLength, right - left + 1);
                
                // Subtract the element at 'left' and move the pointer forward
                currentSum -= nums[left];
                left++;
            }
        }

        // If minLength was never updated, it means no valid subarray exists
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}