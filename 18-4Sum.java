public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num==null ||num.length==0 || num.length<4)
            return result;
        
        Arrays.sort(num);
        for(int i=0; i<num.length-3; i++){
            int val = target-num[i];
            
            for(int j=i+1; j<num.length-2; j++){
                int val2=val-num[j];
                int l=j+1, k=num.length-1;
            
                while(l<k){
                    if(num[l]+num[k]==val2){
                        ArrayList<Integer> item = new ArrayList<Integer>();
                        item.add(num[i]);
                        item.add(num[j]);
                        item.add(num[l]);
                        item.add(num[k]);
                    
                        if(!result.contains(item)) // no duplicate item allowed!!
                            result.add(item);
                        
                        l++;
                        k--;
                    }
                    else if(num[l]+num[k]<val2){
                        l++;
                    }
                    else
                        k--;
                }
            }
        }
        return result;
    }
}
