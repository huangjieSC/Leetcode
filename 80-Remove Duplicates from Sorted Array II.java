public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        
        int count = 1;
        int index = 0;
        nums[index] = nums[0];
        index++;
        
        for(int i=1; i<nums.length; i++){
            if(nums[i]==nums[i-1]){ 
                if(count>=2){
                    continue;
                }
                count++;
            }
            else{
                count=1;
            }
            
            nums[index] = nums[i];
            index++;
        }
        return index;
    }
}
