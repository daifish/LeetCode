/*************************************************************************
    > File Name: 101_SymmetricTree.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/symmetric-tree/
    > Created Time: 三 10/14 17:01:54 2015
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else if (root.left == null && root.right == null) {
            return true;
        }
        
        return help(root.left, root.right);
    }
    
    public boolean help(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } 
        
        if (left == null && right != null || left != null && right == null) {
            return false;
        }
        
        if (left.val != right.val) {
            return false;
        }
        
        return help(left.left, right.right) && help(left.right, right.left);
    }
}
