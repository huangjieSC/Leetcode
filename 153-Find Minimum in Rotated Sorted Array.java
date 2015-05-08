public class Solution {
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0) return -1;
        
        int start=0, end = nums.length-1, mid=0;
        
        while(start<=end){
            mid = start+(end-start)/2;
            if(nums[mid]<nums[end]) end=mid;
            else start=mid+1;
        }
        
        return nums[end];
    }
}
