public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits==null || digits.length ==0) return digits;
        
        int len=digits.length;
        int carry=0;
        for(int i=len-1; i>=0; i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        int[] result = new int[len+1];
        result[0]=1;
        for(int j=0; j<len; j++){
            result[j+1] = digits[j];
        }
        return result;
    }
}
