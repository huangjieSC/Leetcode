/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        
        ListNode curr = head;
        ListNode prev = new ListNode(-1);
        
        prev.next = curr;
        ListNode dummy = prev;
        
        while(curr != null){
            if(curr.val != val){
                prev = curr;
                curr = curr.next;
            }
            else{
                prev.next = curr.next;
                curr = prev.next;
            }
        }
        
        return dummy.next;
    }
}
