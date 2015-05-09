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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null || inorder.length==0 || postorder.length==0 || inorder.length!=postorder.length) return null;
        
        return helper(inorder,0,inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    public TreeNode helper(int[] inorder, int i_start, int i_end, int[] postorder, int p_start, int p_end){
        if(p_start>p_end || i_start>i_end) return null;
        
        TreeNode root = new TreeNode(postorder[p_end]);
        int root_inInorder = 0;
        for(int i=i_start; i<=i_end; i++){
            if(inorder[i]==root.val){
                root_inInorder = i;
                break;
            }
        }
        
        int len_left = root_inInorder-i_start;
        int len_right = i_end-root_inInorder;
        
        root.left = helper(inorder, i_start, i_start+len_left-1, postorder, p_start, p_start+len_left-1);
        root.right = helper(inorder, root_inInorder+1, i_end, postorder, p_start+len_left, p_end-1);
        
        return root;
    }
}
