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
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || k == 1) return head;
        if(lessThanK(head, k)) return head;
        
        // similar to reverse linkedlist problem, this time break the linkedlist into k-length sublist and reverse them, then link them together
        ListNode next;
        ListNode previous = new ListNode(-1);
        
        ListNode node1 = head;
        ListNode node2 = head.next;
        previous.next = node1;
        
        int count = 0;
        while(node1 != null && node2 != null && count < k-1) {
            node1.next = node2.next;//node1交换到node2的后面
            node2.next = previous.next;//node2交换到最开始
            previous.next = node2;//node2作为新的点
            node2 = node1.next;//node2回归到node1的下一个，继续遍历
            
            count++;
        }
        node1.next = reverseKGroup(node2, k);
    
        return previous.next;
    }
    
    public boolean lessThanK(ListNode head, int k){
        if(head == null) return true;
        int count = 0;
        ListNode cur = head;
        while(cur!=null){
             count++;
            if(count >=k) return false;
            cur = cur.next;
       }
            return true;
    }
}
