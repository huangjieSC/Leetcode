public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] index = {-1,-1};
        if(nums==null || nums.length==0) 
            return index;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int remain = 0;
        
        for(int i=0; i<nums.length; i++){
            remain = target-nums[i];
            if(map.containsKey(remain)){
                index[0]=map.get(remain)<i?map.get(remain)+1:i+1;
                index[1]=map.get(remain)<i?i+1:map.get(remain)+1;
                break;
            }
            map.put(nums[i],i);
        }
        return index;
    }
}
