/*************************************************************************
    > File Name: 086_PartitioinList.java
    > Author:  daiyu
	> Url : https://leetcode.com/problems/partition-list/
    > Created Time: 一 10/12 22:05:07 2015
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
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        ListNode node = head, less = lessHead, greater = greaterHead;
        
        while (node != null) {
            ListNode next = node.next;
            if (node.val < x) {
                less.next = node;
                less = less.next;
                less.next = null;
            } else {
                greater.next = node;
                greater = greater.next;
                greater.next = null;
            }
            node = next;
        }
        
        less.next = greaterHead.next;
        return lessHead.next;
    }
}
