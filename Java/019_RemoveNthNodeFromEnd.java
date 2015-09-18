/*************************************************************************
    > File Name: 19_RemoveNthNodeFromEnd.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    > Created Time: 四  9/17 19:10:30 2015
 ************************************************************************/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        
        if (n == 1) {
            if (p1.next == null) {
                return null;
            }
            
            while (p1.next.next != null) {
                p1 = p1.next;
            }
            
            p1.next = null;
            
            return p2;            
        } else {
            for (int i = 0; i < n; i ++) {
                p2 = p2.next;
                if (p2 == null) {
                    return p1.next;
                }
            }        
            
            while (p2.next != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            
            p1.next = p1.next.next;
            
            return head;
        }
    }
}
