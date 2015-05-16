public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack==null || needle==null) return -1;
        if(haystack.length()==0 && needle.length()!=0) return -1;
        if(needle.length()==0) return 0;
        if(haystack.length()==0 && needle.length()==0) return 0;
        if(haystack.length()<needle.length()) return -1;
        
        int hayLen = haystack.length(), neeLen = needle.length();
        int n=0, h=0, index=-1;
        
        for(int i=0; i< hayLen; i++){
            n = 0;
            if(haystack.charAt(i)!=needle.charAt(n)) continue;
            h = i;
            while(h<hayLen && n<neeLen){
                if(haystack.charAt(h)!=needle.charAt(n)) break;
                else{
                    h++;
                    n++;
                }
            }
            if(h<=hayLen && n==neeLen)
                return i;
            else
                continue;
        }
        return -1;
    }
}
