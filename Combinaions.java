public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(n==0 || k>n) return result;
        
        ArrayList<Integer> item = new ArrayList<Integer>();
        dfs(1,n, k,item, result);
        
        return result;
    }
    
    public void dfs(int start, int n, int k, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> result){
        if(item.size()==k){
            result.add(new ArrayList<Integer>(item));
            return;
        }
        
        for(int i=start; i<=n; i++){
            item.add(i);
            dfs(i+1, n, k, item, result);
            item.remove(item.size()-1);
        }
    }
}
