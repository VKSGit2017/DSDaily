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

//Time Complexity - O(n), Space Complexity - O(1)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode front = dummy;
        ListNode rear = head;

        while(n>0){
            n--;
            rear = rear.next;
        }
        while(rear != null){
            front = front.next;
            rear = rear.next;
        }

        front.next = front.next.next;
        return dummy.next;
    }
}
