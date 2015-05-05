/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //Recursive solution
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode left, TreeNode right){
        if(left==null && right==null) return true;
        if(left==null || right==null) return false;
        
        if(left.val!=right.val) return false;
        return helper(left.left, right.right) && helper(left.right,right.left);
    }
}

//Iterative solution

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
    public boolean isSymmetric(TreeNode root) {
       if(root==null) return true;
       
       ArrayList<TreeNode> current = new ArrayList<TreeNode>();
       current.add(root);
       
       while(current.size()!=0){
           ArrayList<TreeNode> next = new ArrayList<TreeNode>();
           int len = current.size();
           int start = 0, end = len-1;
           while(start<len && end>=0 && start<end){
               int l=current.get(start)==null?-1:current.get(start).val;
               int r=current.get(end)==null?-1:current.get(end).val;
          
               if(l!=r) return false;
               start++;
               end--;
           }
           for(TreeNode node: current){
               if(node==null) continue;
               if(node!=null){
                   next.add(node.left);
                   next.add(node.right);
               }
           }
           current = next;
       }
       return true;
    }
}
