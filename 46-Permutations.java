public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(num.length==0)
            return list;
        
        ArrayList<Integer> item = new ArrayList<Integer>();
        boolean[] visited = new boolean[num.length];
        
        for(int k=0; k<visited.length; k++)
            visited[k]=false;
        
        dfs(num, visited, item, list);
        return list;
    }
    
    public void dfs(int[] num, boolean[] visited, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> list){
        if(item.size()==num.length){
            list.add(new ArrayList<Integer>(item));  // IMPORTANT!! cannot write it as list.add(item)!!!!
            return;
        }
        
        for(int i=0; i<num.length; i++){
            if(!visited[i]){
                item.add(num[i]);
                visited[i]=true;
                dfs(num, visited, item, list);
                visited[i]=false;
                item.remove(item.size()-1);
            }
        }
    }
}
