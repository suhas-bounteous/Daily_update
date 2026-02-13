//return the element that occurs more than n/2 times where n is size of array

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int t = nums.length/2;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > t){
                return entry.getKey();
            }
        }
        return 0;
    }
}