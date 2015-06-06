public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums==null || nums.length==0) return false;
        
        Set<Integer> set = new HashSet<Integer>();
        for(int i: nums){
            if(set.contains(i)) return true;
            else
                set.add(i);
        }
        return false;
    }
}
