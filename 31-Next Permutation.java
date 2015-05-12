public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length==0) return;
        
        int len = nums.length;
        int index = len-1;
        while(index<len && index>=0){
            while(index>0 && nums[index-1]>=nums[index]) 
                index--;
            if(index==0){
                Arrays.sort(nums); 
                return;
            }
            else{
                int smaller = index-1;
                int minBigger = index;
                while(minBigger<len && nums[minBigger]>nums[smaller]){
                    minBigger++;
                }
                minBigger--;
                swap(nums,smaller,minBigger);
                Arrays.sort(nums,smaller+1,len);
                return;
            }
        }
    }
    
    public void swap(int[] nums, int i, int j){
        if(nums==null || nums.length==0) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
