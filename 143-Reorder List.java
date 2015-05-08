/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head==null) return;
        
        ListNode slow = head, fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode second = slow.next;
        slow.next = null;
        second = reverseList(second);
        
        ListNode first = head;
        ListNode firstNext, secondNext;
        
        while(first!=null && second!=null){
                firstNext = first.next;
                secondNext = second.next;
                
                first.next = second;
                second.next = firstNext;
                
                first = firstNext;
                second = secondNext;
        }
    }
    
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode node1 = head, node2 = head.next;
        
        while(node1!=null && node2!=null){
            ListNode next = node2.next;
            
            node1.next = next;
            node2.next = prev.next;
            prev.next = node2;
            
            node2 = node1.next;
        }
        return prev.next;
    }
}
