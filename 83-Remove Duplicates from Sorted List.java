/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode curr = head;
        prev.next = head;
        
        ListNode next;
        
        while(curr!=null && curr.next!=null){
            if(curr.val!=curr.next.val){
                prev.next = curr;
                curr = curr.next;
                prev = prev.next;
            }
            else{
                next = curr.next;
                while(next!=null && next.val==curr.val){
                    next = next.next;
                }
                curr.next = next;
                prev.next = curr;
                curr = curr.next;
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}
