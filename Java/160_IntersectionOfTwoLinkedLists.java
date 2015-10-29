/*************************************************************************
    > File Name: 160_IntersectionOfTwoLinkedLists.java
    > Author: daiyu
    > Mail: 122267888@qq.com 
    > Created Time: 四 10/29 16:29:44 2015
 ************************************************************************/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode l1 = headA;
        ListNode l2 = headB;
        int countA = 1;
        int countB = 1;
        
        while (l1.next != null) {
            countA ++;
            l1 = l1.next;
        }
        
        while (l2.next != null) {
            countB ++;
            l2 = l2.next;
        }
        if (l1 != l2) {
            return null;
        } else {
            int count = Math.abs(countA - countB);
            if (countB > countA) {
                l1 = headB;
                l2 = headA;
            } else {
                l1 = headA;
                l2 = headB;
            }
            while ((count --) > 0) {
                l1 = l1.next;
            }
            
            while (l1 != null && l2 != null && l1 != l2) {
                l1 = l1.next;
                l2 = l2.next;
            }
            
            return l1;
        }
    }
}
