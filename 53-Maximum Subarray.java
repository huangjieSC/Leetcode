public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        
        int max=Integer.MIN_VALUE, sum=0;
        for(int i=0; i<nums.length; i++){
            int current = nums[i];
            sum = Math.max(sum+current, current);
            max = Math.max(max, sum);
        }
        return max;
    }
}
