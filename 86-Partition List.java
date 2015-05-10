/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null) return null;
        
        ListNode small = new ListNode(-1);
        ListNode big = new ListNode(-1);
        ListNode sHead = small, bHead = big;
        ListNode curr = head;
        
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = null;
            
            if(curr.val<x){
                small.next=curr;
                small=small.next;
            }
            else{
                big.next=curr;
                big=big.next;
            }
            curr = next;
        }
        if(bHead.next!=null) small.next=bHead.next;
        return sHead.next;
    }
}
