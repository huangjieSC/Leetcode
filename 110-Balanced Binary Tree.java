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
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        return helper(root)!=-1?true:false;
    }
    
    public int helper(TreeNode root){
        if(root==null) return 0;
        
        int left = helper(root.left);
        if(left==-1) return -1;
        
        int right = helper(root.right);
        if(right==-1) return -1;
        
        int diff = Math.abs(left-right);
        if(diff>1) return -1;
        
        return 1+Math.max(left,right);
    }
}
