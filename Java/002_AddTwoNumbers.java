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
 * 思路：定义一个工作链表，当l1,l2都不是最后一位时，进行加法处理（判断是否有进位，如果有，生成一个为1的下一位，l1,l2向下移动）
 * 如果l1,l2都到最后时进行次进位处理
 * 剩下的两种情况相同：如果l1到达末尾，如果没有进位，直接将l2接到工作链表后面
 * 如果有进位，生成一个进位，将l2移到下一位，如果l2之后仍有节点，将l2的节点与进位想加进行溢出判断，跳出之后
 * 如果是由于没有溢出跳出while，则将l2直接接到工作指针之后即可， 如果是由于到最后一位而跳出while，则进行次溢出判断
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
