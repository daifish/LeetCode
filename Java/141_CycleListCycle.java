/*************************************************************************
    > File Name: 141_CycleListCycle.java
    > Author: daiyu
    > Mail: 122267888@qq.com 
    > Created Time: 二 10/27 20:24:08 2015
 ************************************************************************/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        if (head == null || head.next == null) {
            return false;
        }
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (fast == slow) {
                return true;
            }
        }
        
        return false;
    }
}
