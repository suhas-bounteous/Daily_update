//remove all duplicate elements in place
class remove_dup_from_sorted_array {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0; 

        int k = 1; 
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) { 
                nums[k] = nums[i];        
                k++;                      
            }
        }
        return k; 
    }
}