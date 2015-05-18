public class Solution {
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0) return -1;
        int high = nums.length-1, low = 0;
        
        while(low<high){
            int mid = low+(high-low)/2;
        
            if(nums[mid]<nums[high]){ // if right half is sorted
                    high = mid;
            }
            else if(nums[mid]>nums[high]){ // if left half is sorted
                    low = mid+1;
            }
            else
                high--;
            
        }
        return nums[low];
    }
}
