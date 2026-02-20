package Daily_update.DSA;
import java.util.*;
class twoSum {
    public static int[] two_Sum(int[] nums, int target) {
        HashMap<Integer, Integer> a = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (a.containsKey(diff)) {
                return new int[]{a.get(diff), i};
            }

            a.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = two_Sum(nums, target);

        System.out.println("Indices: " + Arrays.toString(result));
    }
}
