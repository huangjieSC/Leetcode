/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return head;
        
        ListNode fast=head;
        ListNode slow=head;
        int i=0;
        
        for(i=0; i<n; i++){
            if(fast==null) break;
            fast=fast.next;
        }
        
         if(i<n) 
            return null;
         if(fast==null) 
            return head.next;
       
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        
        slow.next=slow.next.next;
        return head;
        
    }
}
