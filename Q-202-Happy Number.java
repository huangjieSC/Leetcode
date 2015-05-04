public class Solution {
    /**
         * 解题思路：
模拟题，循环过程中用set记录每次得到的平方和. 当出现非1的重复平方和时，返回False. 否则，返回True
         * */
         
    public boolean isHappy(int n) {
        if(n == 0 || n == 1) return true;
        if(n < 0) return false;
        
        HashSet<Integer> set = new HashSet<Integer>();
        while (true) {
            if (n == 1) {
                break;
            }
            if (!set.contains(n)) {
                set.add(n);
            } else {
                break;
            }
            n = digitSquares(n);
        }
        return n == 1;
    }
    
    public int digitSquares(int n){
        int result = 0;
        
        while(n!= 0){
            result += Math.pow(n%10,2);
            n /= 10;
        }
        return result;
    }
}
