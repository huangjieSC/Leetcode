public class Solution {
    public String fractionToDecimal(int num, int den) {
        if(num==0) return "0";
        int sign = 1;
        
        long numerator = num, denominator = den;
        
        if(numerator < 0 && denominator <0) 
            sign=1;
        else if(numerator > 0 && denominator >0) 
            sign=1;
        else{ 
            sign = -1; 
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        }
        
        HashMap<Long, Integer> map = new HashMap<Long,Integer>();
        
        StringBuilder s = new StringBuilder();
        long div = numerator/denominator;
        
        if(sign == -1) 
            s.append("-");
            
        s.append(div);
        
        long remain = numerator%denominator;
        
        if(remain == 0) return s.toString();
        else s.append('.');
        
        while(remain!=0 && !map.containsKey(remain)){
            map.put(remain,s.length());
            s.append(""+((remain*10)/denominator));
            remain = (remain*10)%denominator;
        }
        
        if(remain==0) return s.toString();
        
        int recurStart = map.get(remain);
        String result = s.toString();
        result = result.substring(0,recurStart)+"("+result.substring(recurStart)+")";
        return result;
    }
}
