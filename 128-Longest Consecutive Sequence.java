public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        
        Set<Integer> set = new HashSet<Integer>();
        int len = Integer.MIN_VALUE;
        int count=0;
        
        for(int i:nums)
            set.add(i);
        
        for(int i=0; i<nums.length; i++){
            count = 0;
            int val = nums[i];
            if(!set.contains(val)) 
                continue;
            else{
                count++;
                val--;
            }
            while(set.contains(val)){
                count++;
                set.remove(val);
                val--;
            }
            val = nums[i]+1;
            while(set.contains(val)){
                count++;
                set.remove(val);
                val++;
            }
            len = Math.max(len,count);
        }
        return len;
    }
}
