public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null || nums.length==0) return 0;
        
        int len = nums.length;
        int sum = 0;
        int curr_size = 0,min_size = Integer.MAX_VALUE;
        int head = 0,tail=0;
        
        while(tail<len){
            while(tail<len && sum<s){
                sum += nums[tail];
                tail++;
            }
            
            while(head < len && sum>=s){
                if(sum>=s){
                    curr_size = tail-head;
                    min_size = Math.min(min_size,curr_size);
                }
                sum -= nums[head];
                head++;
            }
        }
        
        return min_size>len?0:min_size;
    }
}
