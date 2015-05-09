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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null) return list;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(root!=null || !stack.isEmpty()){
            if(root!=null){
                    stack.push(root);
                    root = root.left;
            }
            else{
                TreeNode node = stack.pop();
                list.add(node.val);
                root = node.right;
            }
        }
        return list;
    }
}
