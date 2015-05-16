public class Solution {
    public int divide(int dividend, int divisor) {
        //http://wp.javayu.me/2014/02/divide-two-integers/
        // http://www.cnblogs.com/lautsie/p/3229125.html
        // http://jianliu.org/2015/02/leetcode-29-divide-two-integers/
        // http://dongyuxi.github.io/leetcode/2015-02-15/problem029-divide-two-integers.html
        if (0 == divisor) {
            return Integer.MAX_VALUE;
        }
        long dividendLong = Math.abs((long)dividend);
        long divisorLong = Math.abs((long)divisor);
        boolean sign = false;
        if((dividend < 0 && divisor >0) || (dividend >0 && divisor<0))
            sign = true;
        
        long result = 0;
        
        while (dividendLong >= divisorLong) {
            long base = divisorLong;
            for (int i = 0; dividendLong >= base; i++) {
                dividendLong -= base;
                base <<= 1;
                result += 1 << i;
            }
        }
        result = (sign) ? -result : result;
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int)result;
    }
}
