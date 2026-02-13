//calculate the best time to buy and sell stocks
class Solution {
    public int maxProfit(int[] nums) {
        int lp = 0;
        int p=0;
        for(int i=1; i<nums.length; i++){
            if(nums[i]<nums[lp]){
                lp=i;
            }else{
                int d=nums[i]-nums[lp];
                p = Math.max(p,d);
            }

        }
        return p;
    }
}