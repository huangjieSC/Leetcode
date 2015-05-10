public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        if(s==null || s.length()==0) return list;
        
        ArrayList<String> item = new ArrayList<String>();
        dfs(s, 0, item, list);
        return list;
    }
    
    public void dfs(String s, int start, ArrayList<String> item, ArrayList<ArrayList<String>> list){
        if(start>=s.length()){
            list.add(new ArrayList<String>(item));
            return;
        }
        
        for(int i=start; i<s.length(); i++){
            String sub = s.substring(start, i+1);
            if(isPalin(sub)){
                item.add(sub);
                dfs(s,i+1,item,list);
                item.remove(item.size()-1); // backstracking
            }
        }
    }
    
    public boolean isPalin(String s){
        if(s==null || s.length()==0) return true;
        
        int len = s.length();
        int i=0, j=len-1;
        while(i<j){
            char a = s.charAt(i);
            char b = s.charAt(j);
            if(a!=b) return false;
            i++;
            j--;
        }
        return true;
    }
}
