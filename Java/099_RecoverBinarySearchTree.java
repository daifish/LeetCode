/*************************************************************************
    > File Name: 099_RecoverBinarySearchTree.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/recover-binary-search-tree/
    > Created Time: 三 10/14 16:41:51 2015
 ************************************************************************/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * demo:
 *      1
 *    2   4
 * 3          5
 */
public class Solution {
    TreeNode mis1, mis2;
    TreeNode pre;
    public void recoverTree(TreeNode root) {
        help(root);
        if (mis1 != null && mis2 != null) {
            int tmp = mis1.val;
            mis1.val = mis2.val;
            mis2.val = tmp;
        }
    }
    
    public void help (TreeNode root) {
        if (root == null) {
            return;
        } 
        if (root.left != null) {
            help(root.left);
        }
        if (pre != null && root.val < pre.val) {
            if (mis1 == null) {
                mis1 = pre;
                mis2 = root;
            } else {
                mis2 = root;
            }
        }
        pre = root;
        if (root.right != null) {
            help(root.right);
        }
        
    }
}
