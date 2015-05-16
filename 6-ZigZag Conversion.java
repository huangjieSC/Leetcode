public class Solution {
    public String convert(String s, int numRows) {
        if(s==null || s.length()==0) return s;
        if(numRows==0 || numRows==1) return s;
        if(s.length()<=numRows) return s;
        
        int zigSize = numRows*2-2;
        StringBuilder result = new StringBuilder();
        
        for(int i=0; i<numRows; i++){
            for(int j=0; j<s.length(); j=j+zigSize){
                if(i+j<s.length())
                    result.append(s.charAt(i+j));
                if(i!=0 && i!=numRows-1){
                    if((i+zigSize+j-2*i) < s.length())
                        result.append(s.charAt(i+zigSize+j-2*i));
                }
            }
        }
        return result.toString();
    }
}
