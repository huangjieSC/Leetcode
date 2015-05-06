/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //Idea: level order traversal, for each level, save the rightmost node on this level
 
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null) return list;
        
        List<TreeNode> currentLevel = new ArrayList<TreeNode>();
        currentLevel.add(root);
        while(currentLevel.size()!=0){
            list.add(currentLevel.get(currentLevel.size()-1).val);
            
            List<TreeNode> nextLevel = new ArrayList<TreeNode>();
            for(TreeNode node: currentLevel){
                if(node.left!=null) nextLevel.add(node.left);
                if(node.right!=null) nextLevel.add(node.right);
            }
            currentLevel = nextLevel;
        }
        return list;
    }
}
