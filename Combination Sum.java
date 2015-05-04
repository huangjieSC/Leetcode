public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(candidates==null || candidates.length==0) return result;
        
        Arrays.sort(candidates);
        
        ArrayList<Integer> item = new ArrayList<Integer>();
        dfs(candidates, target, 0, item, result);
        return result;
    }
    
    public void dfs(int[] candidates, int target, int start, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> result){
        if(target<0) return;
        
        if(target==0){
            if(!result.contains(item))
                result.add(new ArrayList<Integer>(item));
            return;
        }
        
        for(int i=start; i<candidates.length; i++){
            if(candidates[i]<=target){
                item.add(candidates[i]);
                dfs(candidates,target-candidates[i],i,item,result);
                item.remove(item.size()-1);
            }
            else
                return;
        }
    }
}
