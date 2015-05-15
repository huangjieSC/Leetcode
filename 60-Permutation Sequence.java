public class Solution {
    public String getPermutation(int n, int k) {
         k--;//to transfer it as begin from 0 rather than 1
        
        List<Integer> numList = new ArrayList<Integer>();  
        for(int i = 1; i<= n; i++)
            numList.add(i);
       
        int factorial = 1;    
        for(int i = 2; i < n; i++)  // get (n-1)!
            factorial *= i;    
        
        StringBuilder res = new StringBuilder();
        int times = n-1;
        
        while(numList.size()>0){ // pay attention to the condition >=0
            int indexInList = k/factorial;
            res.append(numList.get(indexInList));  
            numList.remove(indexInList);  // don't forget to remove!
            
            k = k%factorial;//new k for next turn
            if(times!=0)
                factorial = factorial/times;//new (n-1)!
            
            times--; // don't forget this!!
        }
        
        return res.toString();
    }
}
