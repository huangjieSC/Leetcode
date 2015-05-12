public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] index = {-1,-1};
        if(nums==null || nums.length==0) return index;
        
        int len=nums.length;
        int start=0, end=len-1;
        
        int targetIndex=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                targetIndex=mid;
                break;
            }
            else if(nums[mid]<target)
                start=mid+1;
            else
                end=mid-1;
        }
        
        if(start>end) return index;    // target not found
        
        // search left index
        end = targetIndex;
        start = 0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                end = mid-1;
            }
            else
                start=mid+1;
        }
        index[0] = start;
        
        // search right index
        start = targetIndex;
        end = len-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                start = mid+1;
            }
            else
                end=mid-1;
        }
        index[1] = end;
        
        return index;
    }
}
