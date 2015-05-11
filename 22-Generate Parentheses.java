public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        if(n<=0) return list;
        String s = "";
        
        dfs(n, n, list,s);
        return list;
    }
    
    public void dfs(int leftRemain, int rightRemain, List<String> list, String s){
        if(leftRemain < 0 || rightRemain<0) return;
        
        if(leftRemain==0 && rightRemain==0){
            list.add(new String(s));
        }
        
        if(leftRemain > rightRemain) return;
        
        if(leftRemain<=rightRemain)  
            dfs(leftRemain-1, rightRemain, list, s+"(");
        
        if(rightRemain>0)  
            dfs(leftRemain, rightRemain-1, list, s+")");
        
        return;
    }
}
