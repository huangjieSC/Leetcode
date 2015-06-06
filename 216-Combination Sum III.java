public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
       List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(k==0 || n==0) return result;
        
        int[] input = {1,2,3,4,5,6,7,8,9};
        
        List<Integer> item = new ArrayList<Integer>();
        dfs(k, n, 0, 0,input,item, result);
        return result;
    }
    
    public void dfs(int number, int target, int index, int count, int[] input, List<Integer> item, List<List<Integer>> result){
        if(target<0) return;
        
        if(target==0 && count ==number){
            if(!result.contains(item))
                result.add(new ArrayList<Integer>(item));
            return;
        }
        
        for(int i=index; i<input.length; i++){
            if(input[i]<=target){
                item.add(input[i]);
                dfs(number,target-input[i],i+1,count+1, input, item,result);
                item.remove(item.size()-1);
            }
            else
                return;
        }
    }
}
