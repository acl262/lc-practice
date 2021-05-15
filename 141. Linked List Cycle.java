/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (slow != null && fast.next != null) {
            if(fast == slow) return true;
            slow = slow.next;     
            fast = fast.next.next;
        }
        return false;
    } 
}
