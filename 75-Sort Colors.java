public class Solution {
    public void sortColors(int[] nums) {
        if(nums==null || nums.length==0) return;
        
        int len = nums.length;
        int notRed = 0, notBlue = len-1;
        int k=0;
        
        while(notRed<len && nums[notRed]==0){
                notRed++;
        }
        k = notRed;
            
        while(notBlue>=0 && nums[notBlue]==2){
            notBlue--;
        }
        
        while(k<=notBlue){
            if(nums[k]==0){
                swap(nums,k,notRed);
                notRed++;
                k++;
            }
            else if(nums[k]==2){
                swap(nums,k,notBlue);
                notBlue--;
            }
            else
                k++;
        }
        return;
    }
    
    public void swap(int[] nums, int i, int j){
        if(nums==null || nums.length==0) return;
        
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
