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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        
        if(p.val!=q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}

//Iterative solution, use queue, idea is similar to BFS, level order comparison
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Queue<TreeNode> left = new LinkedList<TreeNode>();
        Queue<TreeNode> right = new LinkedList<TreeNode>();
         
        left.add(p);
        right.add(q);
         
        while (!left.isEmpty() && !right.isEmpty()) {
            TreeNode ln = left.poll();
            TreeNode rn = right.poll();
            
            if (ln == null && rn == null) continue;
            if (ln == null || rn == null) return false;
            if (ln.val != rn.val) return false;
             
            left.add(ln.left); left.add(ln.right);
            right.add(rn.left); right.add(rn.right);
        }
         
        if(!left.isEmpty() || !right.isEmpty())  return false;
        return true;
    }
}

