import java.util.*;

// AllPosSubSeq class to generate all subsequences using bit manipulation
class AllPosSubSeq {
    
    public List<String> getSubsequences(String s) {
        // Length of input string
        int n = s.length();

        // Total subsequences = 2^n
        int total = 1 << n;

        // List to store all subsequences
        List<String> subsequences = new ArrayList<>();

        // Iterate over all bit masks from 0 to 2^n - 1
        for (int mask = 0; mask < total; mask++) {
            // Temporary subsequence builder
            StringBuilder subseq = new StringBuilder();

            // Check each bit position in mask
            for (int i = 0; i < n; i++) {
                // If i-th bit of mask is set, include s.charAt(i)
                if ((mask & (1 << i)) != 0) {
                    subseq.append(s.charAt(i));
                }
            }

            // Store the formed subsequence as string
            subsequences.add(subseq.toString());
        }

        // Return all generated subsequences
        return subsequences;
    }
}

public class Main {
    public static void main(String[] args) {
        // Input string
        String s = "abc";

        // Create AllPosSubSeq object
        AllPosSubSeq sol = new AllPosSubSeq();

        // Get all subsequences
        List<String> subsequences = sol.getSubsequences(s);

        // Print all subsequences
        for (String subseq : subsequences) {
            System.out.println("\"" + subseq + "\"");
        }
    }
}
