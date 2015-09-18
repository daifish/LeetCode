/*************************************************************************
    > File Name: 024_SwapNodesInPairs.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/swap-nodes-in-pairs/
    > Created Time: 五  9/18 11:15:27 2015
    思路：添加一个头指针，方便操作。 具体链接操作 画图看即可
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode l = new ListNode(0);
        ListNode l1 = head;
        ListNode l2 = head.next;
        ListNode l3 = l;
        l.next = head;
        
        while (l1 != null && l2 != null) {
            l1.next = l2.next;
            l3.next = l2;
            l2.next = l1;
            l3 = l1;
            if (l1.next != null) {
                l2 = l1.next.next;
                l1 = l1.next;
            } else {
                break;
            }
        }
        
        return l.next;
    }
}
