public class MinDistToTarget {
    public int getMinDistance(int[] nums, int target, int start) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                min = Math.min(min, Math.abs(start - i));
            }
        }

        return min;
    }
    public static void main(String[] args) {
        MinDistToTarget obj = new MinDistToTarget();
        int[] nums = {1,2,3,4,5};
        int target = 5;
        int start = 3;
        System.out.println(obj.getMinDistance(nums, target, start));
        nums = new int[]{1};
        target = 1;
        start = 0;
        System.out.println(obj.getMinDistance(nums, target, start));
    }
}
