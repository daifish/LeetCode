/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * author:daiyu
 * time :2015-9-15
 * url:https://leetcode.com/problems/add-two-numbers/
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode result = l3;
        
        while (l1.next != null && l2.next != null) {
            result.val = l1.val + l2.val + result.val;
            
            if (result.val >= 10) {
                result.val = result.val % 10;
                result.next = new ListNode(1);
            } else {
                result.next = new ListNode(0);
            }
            
            l1 = l1.next;
            l2 = l2.next;
            result = result.next;
        }
        
        if (l1.next == null && l2.next == null) {
            result.val = l1.val + l2.val + result.val;
            if (result.val >= 10) {
                result.val = result.val % 10;
                result.next = new ListNode(1);
            }
        }
        
        else if (l1.next == null) {
            result.val = l1.val + l2.val + result.val;
            if (result.val >= 10) {
                result.val = result.val % 10;
                result.next = new ListNode(1);
                result = result.next;
                l2 = l2.next;
                while (l2.next != null) {
                    result.val = result.val + l2.val;
                    if (result.val >= 10) {
                        result.val = result.val % 10;
                        result.next = new ListNode(1);
                        result = result.next;
                        l2 = l2.next;
                    }
                    else {
                        break;
                    }
                }
                /*此时跳出while循环有两种情况
                1是没有进位，即l2.next!=null 直接将L2接到result后面即可
                2是循环到了最后一位，此时将进位考虑上进行处理
                */
                if (l2.next != null) {
                    result.next = l2.next;
                } else {
                     result.val = result.val + l2.val;
                     if (result.val >= 10) {
                         result.val = result.val % 10;
                         result.next = new ListNode(1);
                     }
                }
            }  else {
                result.next = l2.next;
            }
        }
        
        else if (l2.next == null) {
            result.val = l1.val + l2.val + result.val;
            if (result.val >= 10){
                result.val = result.val % 10;
                result.next = new ListNode(1);
                result = result.next;
                l1 = l1.next;
                while (l1.next != null) {
                    result.val = result.val + l1.val;
                    if (result.val >= 10) {
                        result.val = result.val % 10;
                        result.next = new ListNode(1);
                        result = result.next;
                        l1 = l1.next;
                    }
                    else {
                        break;
                    }
                }
                if (l1.next != null) {
                    result.next = l1.next;
                } else {
                     result.val = result.val + l1.val;
                     if (result.val >= 10) {
                         result.val = result.val % 10;
                         result.next = new ListNode(1);
                     }
                }
            } else {
                result.next = l1.next;
            }
        }
        
        return l3;
    }
}
