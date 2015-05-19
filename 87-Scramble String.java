public class Solution {
    /**
     * 用递归做更加方便简单些，思路还是上面那个思路，分两刀那种：
“简单的说，就是s1和s2是scramble的话，那么必然存在一个在s1上的长度l1，将s1分成s11和s12两段，同样有s21和s22。
 那么要么s11和s21是scramble的并且s12和s22是scramble的；要么s11和s22是scramble的并且s12和s21是scramble的。” 
     * */
    
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length())  
            return false;  
        
        if(s1.equals(s2))
            return true;
        
        if(s1.length()==1 && s1.charAt(0)==s2.charAt(0))
            return true;
        
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        
        if(!(new String(ch1).equals(new String(ch2))))
            return false;
        
        int len = s1.length();
        for(int split = 1; split<len; split++){
            String s11 = s1.substring(0,split);
            String s12 = s1.substring(split);
            String s21 = s2.substring(0,split);
            String s22 = s2.substring(split);
            
            if(isScramble(s11,s21) && isScramble(s12,s22))
                return true;
            String s211 = s2.substring(len-split);
            String s222 = s2.substring(0,len-split);
            
            if(isScramble(s11,s211) && isScramble(s12,s222))
                return true;
        }
        return false;
    }
}
