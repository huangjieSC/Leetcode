public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null ||nums.length==0 || nums.length<3)
            return -1;
        
        int diff = Integer.MAX_VALUE;
        int result = -1;
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-2; i++){
            if(i==0 || nums[i]!=nums[i-1]){ //avoid duplicate solutions   MUST HAVE, otherwise time limit exceeded!!
                int val=target-nums[i];
                int j=i+1, k=nums.length-1;
            
                while(j<k){
                    if(nums[j]+nums[k]==val){
                        return target;
                    }
                    
                    if(Math.abs(nums[i]+nums[j]+nums[k]-target) < diff){
                        result = nums[i]+nums[j]+nums[k];
                    }
                    diff = Math.min(diff, Math.abs(nums[i]+nums[j]+nums[k]-target));
                    
                    if(nums[j]+nums[k]<val){
                        j++;
                    }
                    else
                        k--;
                }
            }
        }
        return result;
    }
}
