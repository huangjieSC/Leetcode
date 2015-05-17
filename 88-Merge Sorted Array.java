public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2==null || nums2.length==0) return;
        
        int tail = m+n-1;
        int i=m-1, j=n-1;
        
        while(i>=0 && j>=0 && tail>=0){
            if(nums1[i]>nums2[j]){
                nums1[tail] = nums1[i];
                i--;
            }
            else{
                nums1[tail] = nums2[j];
                j--;
            }
            tail--;
        }
        
        while(j>=0){
            nums1[tail] = nums2[j];
            j--;
            tail--;
        }
    }
}
