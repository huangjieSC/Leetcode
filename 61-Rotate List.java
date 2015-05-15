/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        
        int len = 0;
        ListNode curr = head;
        while(curr!=null){
            len++;
            curr=curr.next;
        }
        
        k = k%len;
        if(k==0) return head;
        
        ListNode slow =head, fast = head;
        
        for(int i=0; i<k; i++){
            fast = fast.next;
        }
        
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newHead = slow.next;
        fast.next = head;
        slow.next = null;
        
        return newHead;
    }
}
