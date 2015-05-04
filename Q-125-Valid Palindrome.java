public class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==0)
            return true;
        s = s.toUpperCase();
        int len=s.length();
        int start=0, end=len-1;
        
        while(start<=end){
            char st=s.charAt(start);
            char ed=s.charAt(end);
            
            if(!(st>='A' && st<='Z') && !(st>='0' && st<='9')){
                start++;
                continue;
            }
             if(!(ed>='A' && ed<='Z') && !(ed>='0' && ed<='9')){
                end--;
                continue;
            }
            if(st==ed){
                start++;
                end--;
            }
            else
                return false;
        }
        return true;
    }
}
