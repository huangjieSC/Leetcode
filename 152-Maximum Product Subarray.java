public class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        
        int preMax = nums[0], preMin = nums[0], max = nums[0];
        for(int i=1; i<nums.length; i++){
            int current = nums[i];
            int oldMin = preMin;
            preMin = Math.min(Math.min(preMin*current, preMax*current), current);
            preMax = Math.max(Math.max(oldMin*current, preMax*current), current);
            max = Math.max(max, preMax);
        }
        
        return max;
    }
}
