/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode slow = head, fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode secondStart = slow.next;
        slow.next = null;
        ListNode firstStart = head;
        
        ListNode leftlist = sortList(firstStart);
        ListNode rightlist = sortList(secondStart);
        
        return mergeList(leftlist, rightlist);
    }
    
    public ListNode mergeList(ListNode l1, ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        ListNode prev = new ListNode(-1);
        ListNode curr = prev;
        
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                curr.next = l1;
                l1=l1.next;
            }
            else{
                curr.next=l2;
                l2=l2.next;
            }
            curr=curr.next;
        }
        
        if(l1!=null) curr.next=l1;
        if(l2!=null) curr.next=l2;
        
        return prev.next;
    }
}
