public class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0) return s;
        int max_len = 0, len = s.length();
        int start = 0, end = 0;
        int[] max = {-1,-1};
        
        for(int i= 0; i<len; i++){
            start = i;
            end = i;
            while(start>=0 && end<len){
                if(s.charAt(start)==s.charAt(end)){
                    start--;
                    end++;
                }
                else break;
            }
            max_len = Math.max(max_len,(end-1)-(start+1)+1);
            if(((end-1)-(start+1)+1)>=(max[1]-max[0]+1)){
                 max[0] = start+1;
                 max[1] = end-1;
            }
        }
        
        for(int i= 0; i<len; i++){
            start = i;
            end = i+1;
           while(start>=0 && end<len){
                if(s.charAt(start)==s.charAt(end)){
                    start--;
                    end++;
                }
                else break;
            }
            max_len = Math.max(max_len,(end-1)-(start+1)+1);
            if(((end-1)-(start+1)+1)>=(max[1]-max[0]+1)){
                 max[0] = start+1;
                 max[1] = end-1;
            }
        }
        return s.substring(max[0],max[1]+1);
    }
}
