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
    public List<TreeNode> generateTrees(int n) {
         return generateTreesHelper(1, n);//从1作为root开始，到n作为root结束
    }
    
     public List<TreeNode> generateTreesHelper(int left, int right){
        List<TreeNode> res = new ArrayList<TreeNode>();
         
         if (left > right){ // pay attention to the condition
             res.add(null);
             return res;
        }
        
         for (int i = left; i <= right; i++){ // pay attention to the condition
             List<TreeNode> lefts = generateTreesHelper(left, i-1);//以i作为根节点，左子树由[1,i-1]构成
             List<TreeNode> rights = generateTreesHelper(i+1, right);//右子树由[i+1, n]构成
             for (int j = 0; j < lefts.size(); j++){
                 for (int k = 0; k < rights.size(); k++){
                     TreeNode root = new TreeNode(i);
                     root.left = lefts.get(j);
                     root.right = rights.get(k);
                     res.add(root);//存储所有可能行
                 }
             }
         }
         return res;
     }
}
