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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        if(left !=0 && right !=0) return 1+Math.min(left,right);
        
        return left!=0?1+left:1+right;
    }
}
