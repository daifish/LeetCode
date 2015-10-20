/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 先找到下一组的节点，把本组反转后再递归处理后面的节点
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int number = 0;
        
        while (cur != null && number != k) {
            cur = cur.next;
            number ++;
        }
        
        if (number == k) {
            //找到下一组的头节点
            cur = reverseKGroup(cur, k);
            //将当前组逆向处理，最后记得将最后一个节点处理一下
            while (--number >= 0) {
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        
        return head;
    }
}0
