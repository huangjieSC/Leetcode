public class Solution {
    public int titleToNumber(String s) {
        if(s.length()==0) return 0;
        
        int number = 0;  
        int temp = 0;  
        for(int i = 0; i<s.length();i++)  
        {  
            temp = s.charAt(i) - 'A' + 1;  
            number = number * 26 + temp;  
        }  
        return number;  
    }
}
