public class Solution {
    public int lengthOfLastWord(String s) {
        if(s==null || s.length()==0) return 0;
        
        String[] result = s.split(" ");
        if(result.length!=0)
            return result[result.length-1].length();
        return 0;
    }
}
