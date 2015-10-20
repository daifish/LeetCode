/*************************************************************************
    > File Name: 109_ConvertSortedListToBinarySearchTree.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
    > Created Time: 二 10/20 20:00:37 2015
 ************************************************************************/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode h;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        
        h = head;
        int len = getLength(head);
        return help(0, len - 1);
    }
    
    public int getLength(ListNode head) {
        int len = 0;
        ListNode p = head;
        
        while (p != null) {
            len ++;
            p = p.next;
        }
        
        return len;
    }
    
    public TreeNode help(int start, int end) {
        if (start > end) {
            return null;
        }
        
        int mid = (start + end) / 2;
        
        TreeNode left = help(start, mid - 1);
        TreeNode root = new TreeNode(h.val);
        
        h = h.next;
        TreeNode right = help(mid + 1, end);
        root.left = left;
        root.right = right;
        
        return root;
    }
}
