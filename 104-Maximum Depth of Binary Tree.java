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
  // Recursive Solution
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return 1+Math.max(left,right);
    }
    
  // BFS Solution
   public int maxDepth(TreeNode root) {
       if(root==null) return 0;
       
       int level = 0;
       Queue<TreeNode> queue = new LinkedList<TreeNode>();
       queue.add(root);
       
       while(queue.size()!=0){
           int count = queue.size();
           while(count>0){
               TreeNode node = queue.poll();
               if(node.left!=null)
                    queue.add(node.left);
               if(node.right!=null)
                    queue.add(node.right);
               count--;
           }
           level++;
       }
       return level;
    }
}
