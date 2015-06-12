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
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        /*
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
       */ 
        
        if (root==null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            
            if (node.left!=null) queue.add(node.left);
            if (node.right!=null) queue.add(node.right);
        }
        return root;

    }
}



/**
 *  Another solution
 * */
 
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
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        
        helper(root);
        return root;
    }
    
    public void helper(TreeNode node){
        if(node==null) return;
        
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        
        helper(node.left);
        helper(node.right);
    }
}
