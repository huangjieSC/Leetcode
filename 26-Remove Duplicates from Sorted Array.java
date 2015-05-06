public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        
        int index=0;
        nums[index] = nums[0];
        index++;
        
        for(int i=1; i<nums.length; i++){
            if(nums[i]==nums[i-1]){ 
                continue;
            }
            nums[index] = nums[i];
            index++;
        }
        return index;
    }
}
