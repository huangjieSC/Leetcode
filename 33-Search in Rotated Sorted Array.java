public class Solution {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0) return -1;
        int high = nums.length-1, low = 0;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target) 
                return mid;
            if(nums[mid]<nums[high]){ // if right half is sorted
                if(nums[mid]<target && target<=nums[high])
                    low = mid+1;
                else
                    high = mid-1;
            }
            else{ // if left half is sorted
                if(nums[mid]>target && nums[low]<=target)
                    high = mid-1;
                else
                    low = mid+1;
            }
            
        }
        return -1;
    }
}
