/*************************************************************************
    > File Name: 147_SortList.java
    > Author: daiyu
    > Mail: 122267888@qq.com 
    > Created Time: 四 10/29 14:00:13 2015
 ************************************************************************/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 归并排序，找到中点，不断合并
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }  
        
        ListNode middle = getMiddle(head);
        ListNode next = middle.next;
        middle.next = null;
        return mergeTwo(sortList(head), sortList(next));
    }
    
    public ListNode getMiddle (ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    public ListNode mergeTwo (ListNode first, ListNode second) {
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        
        while (first != null && second != null) {
            if (first.val < second.val) {
                cur.next = first;
                first = first.next;
            } else {
                cur.next = second;
                second = second.next;
            }
            cur = cur.next;
        }
        
        cur.next = first != null ? first : second;
        return pre.next;
    }
}
