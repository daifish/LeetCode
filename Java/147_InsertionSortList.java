/*************************************************************************
    > File Name: 146_InsertSortList.java
    > Author: daiyu
    > Mail: 122267888@qq.com 
    > Created Time: 四 10/29 11:21:48 2015
 ************************************************************************/:w
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode pre = new ListNode(0);
        ListNode p = head.next;
        ListNode cur = head;
        //用于结果返回
        pre.next = head;
        
        while (p != null) {
            if (p.val >= cur.val) {
                p = p.next;
                cur = cur.next;
            } else {
                //新建两个节点 从头指针开始走
                ListNode insertCur = pre;
                ListNode insertP = pre.next;
                while (insertP.val < p.val) {
                    insertCur = insertP;
                    insertP = insertP.next;
                }
                //先把当前p的后续节点保存
                cur.next = p.next;
                //把p插入到指定位置
                p.next = insertP;
                insertCur.next = p;
                p = cur.next;
            }
        }
        
        return pre.next;
    }
}