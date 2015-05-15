public class Solution {
    public int sqrt(int x) {
        if(x==0 || x==1)
            return x;
        if(x<0)
            return -1;
        
        int low = 0;
        int high = x;
        
         while(low<=high){ // pay attention to the condition here
            long mid = (long)(low + high)/2;  // it is long, not int
            
            if(mid*mid < x)
                low = (int)mid + 1;
            else if(mid*mid > x)
                high = (int)mid - 1;
            else
                return (int)mid;
        }
        
        return high; // high points to the smaller value here!!
       
    }
}
