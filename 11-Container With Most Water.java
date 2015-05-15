public class Solution {
    /**
     * 这道题挺类似二分查找法的，这道题是先从两头开始算面积，面积的计算要由短板决定，并维护一个当前最大面积。

 然后逐步替换小的短板来计算面积。每一步只替换短板的原因是，短板决定面积，而高板不影响，所以要想有所改变就改变那个有决定性的东西。。 
     * */
    public int maxArea(int[] height) {
         if(height == null || height.length == 0)
            return 0;
        
        int low = 0, high = height.length -1 ;  
        int max = 0;  
        
       while(low<=high){ // pay attention to the condition here
           int area=(high-low)*Math.min(height[high], height[low]);
           max=Math.max(max,area);
           
           if(height[low]<height[high])
                low++;
            else
                high--;
       }
       
        return max;  
    }
}
