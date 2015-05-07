/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private ArrayList<Integer> list;
    private int index;
    
    public BSTIterator(TreeNode root) {
        list = new ArrayList<Integer>(); 
        index=0;
        inorder(root);
    }
    
    public void inorder(TreeNode root){
        if(root!=null){
            if(root.left!=null) inorder(root.left);
            list.add(root.val);
            if(root.right!=null) inorder(root.right);
        }
        else
            return;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(index<list.size()) return true;
        else return false;
    }

    /** @return the next smallest number */
    public int next() {
        if(index<list.size()){
            int value = list.get(index);
            index++;
            return value;
        } 
        else
            return -1;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
