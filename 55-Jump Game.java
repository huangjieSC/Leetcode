public class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length==0 || nums.length==1) return true;
        
        int maxCover = nums[0];
        for(int i=0; i<=maxCover; i++){
            if(maxCover>=nums.length-1) return true;
            maxCover = Math.max(maxCover, i+nums[i]);
        }
        return false;
    }
}
