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
    public ListNode insertionSortList(ListNode head) {
          if(head == null||head.next == null)  
            return head; 
            
        ListNode sortedlisthead = new ListNode(0);  
        ListNode cur = head;
        
        while(cur!=null){  
            ListNode next = cur.next;  // save next node!!
            ListNode pre = sortedlisthead;  
            while(pre.next!=null && pre.next.val<cur.val)  // pay attention to the conditions
                pre = pre.next;  
            cur.next = pre.next;  
            pre.next = cur;  
            cur = next;  
        }  
        return sortedlisthead.next;  
    }
}
