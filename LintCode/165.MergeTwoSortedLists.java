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

//Recursion递归：Time&Space O(m+n)
public class Solution { 
    /*
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null){
            return l2;
        }
        else if (l2 == null){
            return l1;
        }

        else if (l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

//Iterative循环：Time O(m+n); Space O(1)
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(0);
        ListNode prev = prehead;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
                prev = prev.next;
            }
            else{
                prev.next = l2;
                l2 = l2.next;
                prev = prev.next;
            }
        }
        if(l1 == null){
            prev.next = l2;
        }
        if(l2 == null){
            prev.next = l1;
        }
        return prehead.next;
    }
}