import java.util.HashMap;
import java.util.Map;

public class MinWindowSubStr {

    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        // Dictionary to keep a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            dictT.put(t.charAt(i), dictT.getOrDefault(t.charAt(i), 0) + 1);
        }

        // Number of unique characters in t, which need to be present in the window.
        int required = dictT.size();
        int left = 0, right = 0;

        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its required frequency.
        int formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<>();

        // ans list of the form {window length, left, right}
        int[] ans = {-1, 0, 0};

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            // If the frequency of the current character added matches the desired count in t
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point where it ceases to be 'valid'.
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Save the smallest window until now.
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                // The character at the position pointed by the `left` pointer is no longer a part of the window.
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }

                left++; // Move left pointer to find a smaller window
            }

            right++; // Keep expanding the window
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        
        String result = minWindow(s, t);
        
        System.out.println("Source String: " + s);
        System.out.println("Target Characters: " + t);
        System.out.println("Minimum Window: " + result);
    }
} 