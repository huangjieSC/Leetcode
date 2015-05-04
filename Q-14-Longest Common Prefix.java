public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0 || strs==null)
            return "";
            
        StringBuilder s = new StringBuilder();
        for(int i=0; i<strs[0].length();i++){
            char c = strs[0].charAt(i);
            for(int j=1; j<strs.length;j++){
                if(i<strs[j].length()){
                    if(c!=strs[j].charAt(i))
                        return s.toString();
                }
                else
                    return s.toString();
            }
            s.append(c);
        }
        
        return s.toString();
    }
}
