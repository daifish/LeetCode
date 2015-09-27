/*************************************************************************
    > File Name: 061_RotataList.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/rotate-list/
    > Created Time: 日  9/27 13:18:15 2015
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode countlen = head;
        ListNode newhead = new ListNode(-1);
        int len = 0;
        
        while (countlen != null) {
            len ++;
            countlen = countlen.next;
        }
        
        k = k % len;//k对链表长度取模
        
        if (k == 0) {
            return head;
        }
        
        for (int i = 0; i < k; i ++) {
            fast = fast.next;
        }
        
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        newhead = slow.next;//新的头指针为slow.next
        fast.next = head;//把原队尾接到原头部
        slow.next = null;//尾部置空
        
        return newhead;
    }
}
