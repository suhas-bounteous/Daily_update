//this question asks to sort 2 sorted arrays with space constraints

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l=m+n-1;
        int p = m-1;
        int q = n-1;

        while(p>=0 && q>=0){
            if(nums1[p]>nums2[q]){
                nums1[l]=nums1[p];
                l--;
                p--;
            }else{
                nums1[l]=nums2[q];
                l--;
                q--;
            }
        }
        if(q>=0){
            while(q>=0){
                nums1[l]=nums2[q];
                l--;
                q--;
            }
        }
    }
}