public class Solution {
    public int climbStairs(int n) {
        //dp solution
        if(n==0) return 1;
        if(n==1 || n==2) return n;
        
        int nminusOne = 1;
        int nminusTwo = 1;
        int current = 0;
        
        for(int i=2; i<=n; i++){
            current = nminusOne + nminusTwo;
            nminusTwo = nminusOne;
            nminusOne = current;
        }
        return current;
    }
}
