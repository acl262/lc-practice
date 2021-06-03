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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null) return head;
        
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode fast = head, slow = head;
        ListNode first = dummyNode;
        for(int i = 0; i < right-1; i++) {
            slow = slow.next;
        }
        
        for(int i = 0; i < left-1; i++) {
            first = fast;
            fast = fast.next;
        }
        
        ListNode remaining = slow.next;
        slow.next =null;
        ListNode fast2 = fast;
        first.next = reverse(fast);
        fast2.next = remaining;
        return dummyNode.next;   
    }
    
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        
        while(cur !=null ) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
