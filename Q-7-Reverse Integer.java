public class Solution {
    public int reverse(int input) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // http://stackoverflow.com/questions/3806126/java-reverse-int-value

       if(input==Integer.MIN_VALUE)
            return 0;
       
       int num = Math.abs(input);
       int result=0;
       
       while(num>0){
           if(result>(Integer.MAX_VALUE-num%10)/10)
                return 0;
        
            result=result*10+num%10;
            num/=10;
       }
       
       return input>0?result:-result;
    }
}
