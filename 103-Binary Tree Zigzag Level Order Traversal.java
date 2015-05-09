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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(root==null) return list;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        boolean reverse = false;
        
        queue.add(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> item = new ArrayList<Integer>();
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                item.add(node.val);
                
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            if(!reverse)
                list.add(item);
            else{
                Collections.reverse(item);
                list.add(item);
            }
            reverse = !reverse;
        }
        return list;
    }
}
