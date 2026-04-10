public class MinSubArr {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        // Target sum we need to reach or exceed
        int targetSum = k * threshold; 
        int n = arr.length;
        int count = 0;
        int currentSum = 0;

        // 1. Build the initial window
        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }
        
        // Check the first window
        if (currentSum >= targetSum) count++;

        // 2. Slide the window across the rest of the array
        for (int i = k; i < n; i++) {
            // Add the new element, subtract the one leaving the window
            currentSum += arr[i] - arr[i - k];
            
            // MUST be >= to match the first check
            if (currentSum >= targetSum) { 
                count++;
            }
        }
        
        return count;
    }
} 