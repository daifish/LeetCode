/*************************************************************************
    > File Name: 110_BalancedBinaryTree.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/balanced-binary-tree/
    > Created Time: 二 10/20 20:05:09 2015
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if (help(root) == -1) {
            return false;
        }
        
        return true;
    }
    
    public int help (TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = help(root.left);
        int right = help(root.right);
        
        if (left == -1 || right == -1) {
            return -1;
        }
        
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        
        return Math.max(left, right) + 1;
    }
}
