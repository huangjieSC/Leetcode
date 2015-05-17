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
    /**
     * 就是维护3个指针，startpoint，node1和node2。
 startpoint永远指向需要开始reverse的点的前一个位置。
 node1指向正序中第一个需要rever的node，node2指向正序中第二个需要reverse的node。 
 交换后，node1 在后，node2在前。这样整个链表就逆序好
    *
    **/
   public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newhead = new ListNode(-1);
        newhead.next = head;
        
        if(head==null||head.next==null)
            return head;
            
        ListNode startpoint = newhead;//startpoint指向需要开始reverse的前一个
        ListNode node1 = null;//需要reverse到后面去的节点
        ListNode node2 = null;//需要reverse到前面去的节点
        
        for (int i = 0; i < n; i++) {
            if (i < m-1){
                if(startpoint!=null)
                    startpoint = startpoint.next;//找真正的startpoint
            } else if (i == m-1) {//开始第一轮
                if(startpoint!=null) 
                    node1 = startpoint.next;
                if(node1!=null) 
                    node2 = node1.next;
            }else {
                if(node1!=null && node2!=null){
                    node1.next = node2.next;//node1交换到node2的后面
                    node2.next = startpoint.next;//node2交换到最开始
                    startpoint.next = node2;//node2作为新的点
                    node2 = node1.next;//node2回归到node1的下一个，继续遍历
                }
            }
        }
        return newhead.next;
    }
}
