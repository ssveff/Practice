/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        int l = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head.next != null){
            l++;
            head = head.next;
        }
        head = dummy.next;
        n = l - n + 1;
        if (n == 1){
            return head.next;
        }
        for (int i = 1; i < n - 1; i++){
            head = head.next;
        }
        head.next = head.next.next;
        return dummy.next;
    }
}