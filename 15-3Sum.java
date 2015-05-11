public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num==null ||num.length==0 || num.length<3)
            return result;
        
        Arrays.sort(num);
        
        for(int i=0; i<num.length-2; i++){
            if(i==0 || num[i]!=num[i-1]){ //avoid duplicate solutions   MUST HAVE, otherwise time limit exceeded!!
                int val=0-num[i];
                int j=i+1, k=num.length-1;
            
                while(j<k){
                    if(num[j]+num[k]==val){
                        ArrayList<Integer> item = new ArrayList<Integer>();
                        item.add(num[i]);
                        item.add(num[j]);
                        item.add(num[k]);
                    
                        if(!result.contains(item)) // no duplicate item allowed!!
                            result.add(item);
                        
                        j++;
                        k--;
                        while(j<k && num[k]==num[k+1]) k--;//avoid duplicate solutions 
                        while(j<k && num[j]==num[j-1]) j++;//avoid duplicate solutions
                    }
                    else if(num[j]+num[k]<val){
                        j++;
                    }
                    else
                        k--;
                }
            }
        }
        
        return result;
    }
}
