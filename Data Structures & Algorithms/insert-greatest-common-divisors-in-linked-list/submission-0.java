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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode current = head;

        while(current.next != null){
            int n1 = current.val;
            int n2 = current.next.val;
            int gcdv = gcd(n1, n2);
            ListNode newNode = new ListNode(gcdv, current.next);
            current.next = newNode;
            current = newNode.next;
        }
        return head;
    }
    private int gcd(int a, int b){
        while(b > 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
