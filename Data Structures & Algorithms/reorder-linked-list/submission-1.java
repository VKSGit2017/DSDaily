/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode fast=head, slow=head, prev=null;
        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        prev.next = null;
        ListNode l2 = reverseList(slow), nextL2;
        ListNode l1 = head, nextL1;

        while(l1 != null && l2 != null){
            nextL1= l1.next;
            nextL2 = l2.next;
            l1.next = l2;
            if(nextL1 != null){ 
                l2.next = nextL1;
            }
            l1 = nextL1;
            l2 = nextL2; 
        }
    }

    public ListNode reverseList(ListNode head) {
        //if(head == null) return;
        ListNode cur=head, next, prev=null;
        while(cur != null){
           next = cur.next;
           cur.next = prev;
           prev = cur;
           cur = next; 
        }
        return prev;
    }
}
