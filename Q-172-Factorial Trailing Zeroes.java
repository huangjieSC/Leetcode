public class Solution {
    public int trailingZeroes(int n) {
        // n!后缀0的个数 = n!质因子中5的个数 = floor(n/5) + floor(n/25) + floor(n/125) + ....
       
        int count_five = 0;
        while ( n != 0) {
            int k = n / 5;
            count_five += k;
            n = k;
        }
        return count_five;
        
    }
}
