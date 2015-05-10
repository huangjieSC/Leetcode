/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {  
        ArrayList<Integer> pre = new ArrayList<Integer>();  
        pre.add(null);  // pay attention
        return helper(root, pre);  
    }  
    private boolean helper(TreeNode root, ArrayList<Integer> pre){
        if(root == null)  return true; 
    
        boolean left = helper(root.left,pre); 
        if(!left) return false;
    
        if(pre.get(pre.size()-1)!=null && root.val<=pre.get(pre.size()-1))  
            return false;  
        pre.add(root.val);  
    
        boolean right = helper(root.right,pre);
        return left && right;  
    }
}
