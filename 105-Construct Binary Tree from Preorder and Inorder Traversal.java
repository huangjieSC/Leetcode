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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null || preorder.length==0 || inorder.length==0 || preorder.length!=inorder.length) return null;
        
        return helper(preorder,0,preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    public TreeNode helper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end){
        if(p_start>p_end || i_start>i_end) return null;
        
        TreeNode root = new TreeNode(preorder[p_start]);
        int root_inInorder = 0;
        for(int i=i_start; i<=i_end; i++){
            if(inorder[i]==root.val){
                root_inInorder = i;
                break;
            }
        }
        
        int len_left = root_inInorder-i_start;
        int len_right = i_end-root_inInorder;
        
        root.left = helper(preorder, p_start+1,p_start+len_left, inorder, i_start, root_inInorder-1);
        root.right = helper(preorder, p_start+len_left+1, p_end, inorder, root_inInorder+1, i_end);
        
        return root;
    }
}
