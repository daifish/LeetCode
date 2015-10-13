/*************************************************************************
    > File Name: 092_ReverseLinkedListII.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/reverse-linked-list-ii/
    > Created Time: 二 10/13 09:20:00 2015
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode firstTail = preHead;
        int k = m - 1;
        //0->(m - 1)th
        while (k > 0) {
            firstTail = firstTail.next;
            k --;
        }
        //mth for example in here secondeTail -> 2
        ListNode secondTail = firstTail.next;
        //m-n reverse then 4->3->2
        ListNode tmpHead = null;
        ListNode tmpNext = null;
        ListNode node = firstTail.next;
        k = n - m + 1;
        
        while (k > 0) {
            tmpHead = node;
            node = node.next;
            
            tmpHead.next = tmpNext;
            tmpNext = tmpHead;
            k --;
        }
        
        firstTail.next = tmpHead;
        secondTail.next = node;
        
        return preHead.next;
        
        
        
    }
}
