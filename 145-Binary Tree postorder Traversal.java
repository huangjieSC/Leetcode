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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        
        Stack<TreeNode> oldS = new Stack<TreeNode>();
        Stack<TreeNode> newS = new Stack<TreeNode>();
        
        oldS.push(root);
        while(!oldS.isEmpty()){
            TreeNode node = oldS.pop();
            newS.push(node);
            if(node.left!=null)
                oldS.push(node.left);
            if(node.right!=null)
                oldS.push(node.right);
        }
        
        while(!newS.isEmpty()){
            result.add(newS.pop().val);
        }
        return result;
    }
}
