public class Solution {
    /**
     * An element m appearing more than n/2 times in the array means that the number of elements 
     which is equal to m is greater than the ones which are different than m. 
     So, if we increment the number by 1 for the m and decrement the number by for other different element, 
     the element left which has count greater than 1 will be the majority element m. 
     * */
    public int majorityElement(int[] nums) {
        int count = 0; 
        int major = nums[0];
        for(int i:nums){
            if(count==0){ 
                major=i; count++; 
            }
            else if(i==major) 
                count++;
            else 
                count--;
        }
        return major;
    }
}
