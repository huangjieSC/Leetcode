public class Solution {
    public int singleNumber(int[] nums) {
     int[] count = new int[32];
     int result = 0;
     
     for(int i=0; i<32; i++){
         for(int j=0; j<nums.length; j++){
             int bit = (nums[j]>>i)&1;
             count[i] += bit;
         }
         
         if(count[i]%3!=0)
            result |= 1<<i;
     }
     
     return result;
    }
}
