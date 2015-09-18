/*************************************************************************
    > File Name: 021_MergeTwoList.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/merge-two-sorted-lists/
    > Created Time: 五  9/18 10:20:29 2015
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
    /*
        注意：对于java中的这种链表，要创建两个node，一个作为纪录开始如下的head
        另一个作为工作指针一直移动，此外，对于给出的两个链表，终止条件判断当前的是否为null即可
        不要用l1.next 是否为null去判断
    */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode l = head;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l.next = l1;
                l1 = l1.next;
            } else {
                l.next = l2;
                l2 = l2.next;
            }
            l = l.next;
        }
        
        if (l1 == null) {
            l.next = l2;
        } else if (l2 == null) {
            l.next = l1;
        }
        
        return head.next;
    }
}
