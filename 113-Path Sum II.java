/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(root==null) return list;
        ArrayList<Integer> item = new ArrayList<Integer>();
        
        dfs(root, sum, item, list);
        return list;
    }
    
    public void dfs(TreeNode root, int sum, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> list){
        if(root==null) return;
        item.add(root.val);
        int newSum = sum-root.val;
        
        if(newSum==0 && root.left==null && root.right==null){
            list.add(new ArrayList<Integer>(item));
        }
        else{
            if(root.left!=null) dfs(root.left,newSum,item, list);
            if(root.right!=null) dfs(root.right,newSum,item,list);
        }
        item.remove(item.size()-1);
    }
}
