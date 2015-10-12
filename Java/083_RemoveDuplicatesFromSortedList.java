/*************************************************************************
    > File Name: 083_RemoveDuplicatesFromSortedList.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    > Created Time: 一 10/12 16:36:59 2015
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode prev = head;
        ListNode p = head.next;
        
        while (p != null) {
            if (p.val == prev.val) {
                prev.next = p.next;
                p = p.next;
            } else {
                prev = p;
                p = p.next;
            }
        }
        
        return head;
    }
}
