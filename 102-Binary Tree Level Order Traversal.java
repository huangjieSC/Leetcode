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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root==null) return list;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while(queue.size()!=0){
            List<Integer> item = new ArrayList<Integer>();
            
            int count = queue.size();
            while(count>0){
                TreeNode node = queue.poll();
                item.add(node.val);
                if(node.left!=null) 
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
                count--;
            }
            list.add(item);
        }
        return list;
    }
}
