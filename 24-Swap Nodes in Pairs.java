/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode prev = new ListNode(-1);
        ListNode dummy = new ListNode(-1);
        dummy = prev;
        prev.next = head;
        ListNode n1 = head, n2 = n1.next;
        
        while(n1!=null && n2!=null){
            ListNode next = n2.next;
            n1.next = next;
            n2.next = n1;
            
            prev.next = n2;
            prev = n1;
            n1 = next;
            if(n1!=null) n2 = n1.next;
        }
        return dummy.next;
    }
}
