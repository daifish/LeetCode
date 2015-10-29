/*************************************************************************
    > File Name: 143_ReorderList.java
    > Author: daiyu
    > Mail: 122267888@qq.com 
    > Created Time: 四 10/29 09:40:04 2015
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        //find the mid
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //reverse the mid to the end
        ListNode p = slow.next;
        slow.next = null;
        ListNode pPre = null;
        ListNode pSuf = p;
        while (p != null) {
            pSuf = p.next;
            p.next = pPre;
            pPre = p;
            p = pSuf;
        }
        
        ListNode l1 = head;
        ListNode l2 = pPre;
        //combine. now the l2 head is pPre
        while (l1 != null && l2 != null) {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;
            l1.next = l2;
            l2.next = l1Next;
            l1 = l1Next;
            l2 = l2Next;
        }
    }
}
