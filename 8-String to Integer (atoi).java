public class Solution {
    public int myAtoi(String str) {
        if(str==null || str.length()==0) return 0;
        
        int len = str.length();
        int i=0;
        while(i<len && str.charAt(i)==' '){
            i++;
        }
        
        int sign = 1;
        if(i<len && str.charAt(i)=='-'){
            sign = -1;
            i++;
        } 
        else if(i<len && str.charAt(i)=='+')
            i++;
        
        int result = 0;
        while(i<len && str.charAt(i)>='0' && str.charAt(i)<='9'){
            int digit = str.charAt(i)-'0';
            if(result>(Integer.MAX_VALUE-digit)/10){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            result = result*10+digit;
            i++;
        }
        return sign==1?result:-result;
    }
}
