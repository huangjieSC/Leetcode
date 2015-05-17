public class Solution {
    /**
     * 动态规划来做。

 设置动态数组dp[n+1]。dp[i]表示从1~i的decode ways的个数。
 当给的code只有一位数时，判断是不是valid（A~Z），是的话就dp[1] = 1 不是的话就是dp[1] = 0
 因为像给的例子12可以有两种可能的解析方法，所以计算dp[i]的时候要判断两种可能性，再累加。
     * */
  
    public int numDecodings(String s) {  
        if (s.length()==0||s==null||s=="0")  // do not forget the case when it is "0"
            return 0; 

        int[] dp = new int[s.length()+1];  
        dp[0] = 1;  // important!!
        
        if (isValid(s.substring(0,1))) // important!
            dp[1] = 1;  
        else 
            dp[1] = 0; 
        
        for(int i=2; i<=s.length();i++){  // it is i<= not i<, pay attention!!
            if (isValid(s.substring(i-1,i)))  // similar to jump stairs
                dp[i] += dp[i-1];  
            if (isValid(s.substring(i-2,i)))  
                dp[i] += dp[i-2];  
        }  
        return dp[s.length()];  
    }  
      
    public boolean isValid(String s){  
        if (s.charAt(0)=='0') 
            return false;  
        int code = Integer.parseInt(s);   // convert to int!!
        return code>=1 && code<=26;  
    }
}
