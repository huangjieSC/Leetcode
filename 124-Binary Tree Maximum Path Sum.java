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
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        maxPath(root, res);
        return res[0];
    }
    
    private int maxPath(TreeNode root, int[] res) {
        if (root == null)
            return 0;
        int left = maxPath(root.left, res);
        int right = maxPath(root.right, res);
        
        int arch = left + right + root.val; 
        int single = Math.max(root.val, Math.max(left, right) + root.val);
        
        res[0] = Math.max(res[0], Math.max(arch, single));
        return single;
    }
}
