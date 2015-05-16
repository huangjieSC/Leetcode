/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
        public int compare(ListNode n1, ListNode n2) {
            return n1.val-n2.val;
        }
        });
        
        for(ListNode node: lists){
            if(node!=null)
                queue.offer(node);
        }
        
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while(queue.size()!=0){
            ListNode min = queue.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next!=null)
                queue.offer(min.next);
        }
        return head.next;
    }
}
