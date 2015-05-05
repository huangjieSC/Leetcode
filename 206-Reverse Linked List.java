/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode node1 = head;
        ListNode node2 = head.next;
        
        while(node1!=null && node2!=null){
            ListNode next = node2.next;
            
            node1.next=next;
            node2.next=prev.next;
            prev.next = node2;
            
            node2=node1.next;
        }
        return prev.next;
    }
}
