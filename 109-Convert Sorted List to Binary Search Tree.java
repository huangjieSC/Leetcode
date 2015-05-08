/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)  
            return null;
            
        if(head.next==null) // don't forget the case when the list has only a single node!!
            return new TreeNode(head.val);
        
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=slow;
        
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        
        TreeNode root= new TreeNode(slow.val);
        ListNode rightStart=slow.next;
        prev.next=null;
        
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(rightStart);
        
        return root;
    }
}
