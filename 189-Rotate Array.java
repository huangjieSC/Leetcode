public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums==null || nums.length == 0) return;
        
        int len = nums.length;
        int step = k%len;
        if(step == 0) return;
        
        reverseArray(nums, 0, len-1);
        reverseArray(nums, 0, step-1);
        reverseArray(nums, step,len-1);
    }
    
    public void reverseArray(int[] nums, int start, int end){
        if(nums==null || nums.length == 0) return;
        
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
