public class Solution {
    public int numTrees(int n) {
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        
        int[] C = new int[n+1];
        C[0]=1;
        C[1]=1;
        
        for(int num=2;num<=n;num++){ 
            for(int i=0;i<=num-1;i++){ // pay attention to the condition!!! 
                C[num] += C[i]*C[(num-1)-i];  
            }  
        }
        
        return C[n];
    }
}
