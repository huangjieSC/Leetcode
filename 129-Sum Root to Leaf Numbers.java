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
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        
        return helper(root,0);
    }
    
    public int helper(TreeNode root, int sum){
        if(root==null)
            return 0;
        
         if(root.left==null && root.right==null) // I forgot this...
            return sum*10+root.val;
        
        int currVal=sum*10+root.val;
        return helper(root.left,currVal)+helper(root.right,currVal);
    }
}
