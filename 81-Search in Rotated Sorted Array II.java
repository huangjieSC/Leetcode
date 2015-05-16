public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums==null || nums.length==0) return false;
        int high = nums.length-1, low = 0;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target) 
                return true;
        
            if(nums[mid]<nums[high]){ // if right half is sorted
                if(nums[mid]<target && target<=nums[high])
                    low = mid+1;
                else
                    high = mid-1;
            }
            else if(nums[mid]>nums[low]){ // if left half is sorted
                if(nums[mid]>target && nums[low]<=target)
                    high = mid-1;
                else
                    low = mid+1;
            }
            else if(nums[mid]==nums[high]){
                high--;
            }
            else
                low++;
            
        }
        return false;
    }
}
