public class Solution {
   /**
    *  这道题跟Permutaitons没啥大的区别，就是结果去重。

  过去重的两个方法:

 一个是在加入结果的时候用contains判断，一个是在找结果的时候看他是不是跟前一个元素相同。

 这道题还要考虑的是visited情况，前一个元素就算跟当前元素相同，如果visited==true也没关系。但是如果前面元素跟当前元素相同还没被visited，那么就要做去重处理了。
    * */
    
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> item = new ArrayList<Integer>();
        
        if(num.length==0||num==null)
            return res;
            
        boolean[] visited = new boolean[num.length];  
        
        Arrays.sort(num);
        
        permutation_helper(num,res,item,visited);
        return res;
    }
    
    public void permutation_helper(int[] num, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> item,boolean[] visited){
        if(item.size()==num.length){
            if(!res.contains(item))
            res.add(new ArrayList<Integer>(item));
            return;
        }
        
        for(int i = 0; i<num.length;i++){
            if(i>0 && num[i-1] == num[i] && !visited[i-1])
                continue;
            if(!visited[i]){
                item.add(num[i]);
                visited[i]=true;
                permutation_helper(num,res,item,visited);
                item.remove(item.size()-1);
                visited[i]=false;
            }
        }
    }
}
