/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if(num.length==0)
            return null;
        return sortedArrayHelper(num, 0, num.length-1);
    }
    
    public TreeNode sortedArrayHelper(int[] num, int low, int high){
        if(num.length==0)
            return null;
          if(low > high) // i forgot to add this!!
            return null;
        
        int mid=low+(high-low)/2;
        TreeNode root=new TreeNode(num[mid]);
        
        root.left=sortedArrayHelper(num,low, mid-1);
        root.right=sortedArrayHelper(num,mid+1,high);
        
        return root;
    }
}
