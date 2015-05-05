public class Solution {
    public String addBinary(String a, String b) {
        if(a == null && b == null) return null;
        if(a == null || b == null) return a==null?b:a;
        
        int lenA = a.length();
        int lenB = b.length();
        
        int i=lenA-1, j=lenB-1;
        int carry = 0, result = 0;
        
        StringBuilder r = new StringBuilder();
        while(i>=0 || j>=0 ){
            int valA =0, valB=0;
            
            if(i>=0){
                valA=a.charAt(i)-'0';
            }
            else
                valA = 0;
                
            if(j>=0){
                valB=b.charAt(j)-'0';
            }
            else 
                valB = 0;
                
            result = valA+valB+carry;
            carry = result/2;
            result = result%2;

            r.insert(0,result+"");
            i--;
            j--;
        }
        if(carry==1)
            r.insert(0,carry+"");
            
        return r.toString();
    }
}
