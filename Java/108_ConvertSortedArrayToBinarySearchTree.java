/*************************************************************************
    > File Name: 108_ConvertSortedArrayToBinarySearchTree.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
    > Created Time: 二 10/20 19:58:43 2015
 ************************************************************************/
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        
        return help(nums, 0 , nums.length - 1);
    }
    
    public TreeNode help(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = help(nums, start, mid - 1);
        root.right = help(nums, mid + 1, end);
        
        return root;
    }
}
