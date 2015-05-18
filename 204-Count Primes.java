public class Solution {
    public int countPrimes(int n) {
        boolean[] num = new boolean[n];
        for(int i=2; i<n; i++){
            num[i] = true;
        }
        
        int start = 2;
        while(Math.pow(start,2)<=n){
            for(int i = 2, index = 2*start; index<n; i++, index = start*i){
                num[index] = false;
            }
            
            start++;
           while(Math.pow(start, 2)<=n && num[start]==false){
                start++;
            }
        }
        
        int count = 0;
        for(boolean i: num){
            if(i) count++;
        }
        
        return count;
    }
}
