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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head, medium = head, slow = head;
        for(int i =0; i < k -1; i++) {
            slow = slow.next;
            fast = fast.next;
        }
        while(fast.next != null) {
            medium = medium.next;
            fast = fast.next;
        }
        if(medium != null) {
            int tmp = medium.val;
            medium.val = slow.val;
            slow.val = tmp;
        }
        
        return head;
    }
}
