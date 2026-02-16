//rotate the array without any extra space, this approach is the most optimal as it does not use any extra space
class rotate_array {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);

    }

    public void reverse(int[] nums, int s, int e){
        while(s<e){
            int temp = nums[s];
            nums[s]=nums[e];
            nums[e]=temp;
            s++;
            e--;
        }
    }
}