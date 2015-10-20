/*************************************************************************
    > File Name: 114_FlattenBinaryTreeToLinkedList.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
    > Created Time: 二 10/20 20:08:49 2015
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
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    //找到中序的左子数最右节点
                    pre = pre.right;
                }
                //把当前根节点的右子树都接到pre之后，右子树置为左子树，左子树置空
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            } else {
                root = root.right;
            }
        }
    }
}
