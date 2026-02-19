import java.util.*;

public class frog_jump_1 {
    private int solve(int ind, int[] height, int[] dp) {

        if (ind == 0)
            return 0;

        if (dp[ind] != -1)
            return dp[ind];

        int jumpTwo = Integer.MAX_VALUE;
        int jumpOne = solve(ind - 1, height, dp) + Math.abs(height[ind] - height[ind - 1]);

        if (ind > 1) {
            jumpTwo = solve(ind - 2, height, dp) + Math.abs(height[ind] - height[ind - 2]);
        }
        dp[ind] = Math.min(jumpOne, jumpTwo);
        return dp[ind];
    }

    public int frogJump(int[] height) {

        if (height == null || height.length == 0)
            return 0;

        int n = height.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(n - 1, height, dp);
    }

    public static void main(String[] args) {

        int[] height = { 30, 10, 60, 10, 60, 50 };

        frog_jump_1 sol = new frog_jump_1();

        System.out.println(sol.frogJump(height));
    }
}
