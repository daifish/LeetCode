/*************************************************************************
    > File Name: 111_MinimumDepthOfBinaryTree.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/minimum-depth-of-binary-tree/
    > Created Time: 二 10/20 20:06:31 2015
 ************************************************************************/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 采用递归的思想，分别求左右子树的最小深度，比较之后返回较小值。
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return 1;
        } else {
            int leftDepth = root.left != null ? minDepth(root.left) : Integer.MAX_VALUE;
            int rightDepth = root.right != null ? minDepth(root.right) : Integer.MAX_VALUE;
            
            return Math.min(leftDepth, rightDepth) + 1;
        }
    }
}
