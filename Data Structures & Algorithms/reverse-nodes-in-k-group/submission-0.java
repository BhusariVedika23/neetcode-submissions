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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode a = dummy;
        while(true){
            ListNode b = getk(a, k);
            if(b == null){
                break;
            }
            ListNode c = b.next;
            ListNode d = b.next;
            ListNode e = a.next;
            while(e != c){
                ListNode tmp = e.next;
                e.next = d;
                d = e;
                e = tmp;
            }
            ListNode tmp = a.next;
            a.next = b;
            a = tmp;
        }
        return dummy.next;
    }
    private ListNode getk(ListNode e, int k){
        while(e != null && k > 0){
            e = e.next;
            k--;
        }
        return e;
    }
}
