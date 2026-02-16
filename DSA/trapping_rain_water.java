//this is a common leetcode hard question uses 2 pointer approach
public class trapping_rain_water {
    public int trap(int[] height) {
        if(height==null || height.length == 0) return 0;
        int left = 0;
        int n = height.length;
        int right = n-1;
        int ml = 0, mr =0;
        int total = 0;

        while(left<right){
            if(height[left] < height[right]){
                if(height[left]>ml){
                    ml = height[left];
                }else{
                    total += ml - height[left];
                }
                left++;
            }else{
                if(height[right]>=mr){
                    mr = height[right];
                }else{
                    total += mr - height[right];
                }
                right--;
            }
        }
        return total;
    }
}
