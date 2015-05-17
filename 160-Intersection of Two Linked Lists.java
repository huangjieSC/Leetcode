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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB==null) return null;
        ListNode A = headA;
        ListNode B= headB;
        
        int lenA = 0;
        int lenB = 0;
        
        while(A!=null){
            A=A.next;
            lenA++;
        }
        
        while(B!=null){
            B=B.next;
            lenB++;
        }
        
        A=headA;
        B=headB;
        
        int diff = Math.abs(lenA-lenB);
        if(lenA>lenB){
            for(int i=0; i<diff; i++){
                A=A.next;
            }
        }
        
        if(lenA<lenB){
            for(int j=0; j<diff; j++){
                B=B.next;
            }
        }
        
        while(A!=null && B!=null && A!=B){
            A = A.next;
            B = B.next;
        }

      return A;
    }
}
