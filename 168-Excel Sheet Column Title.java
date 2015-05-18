public class Solution {
    // 从least significant digit开始，不断地除以26取余数
    // 是十进制转换26进制，而且是从1开始的1十进制的转换
     public String convertToTitle(int n) {
        if (n <= 0) return "";
        StringBuffer res = new StringBuffer();
        
        while (n > 0) {
            res.insert(0, (char)('A' + (n-1)%26)); 
            n = (n-1) / 26;  
        }
        return res.toString();
     }
}
