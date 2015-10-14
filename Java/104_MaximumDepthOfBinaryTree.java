/*************************************************************************
    > File Name: 104_MaximumDepthOfBinaryTree.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/maximum-depth-of-binary-tree/
    > Created Time: 三 10/14 18:48:17 2015
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
    public int maxDepth(TreeNode root) {
        int result = 0;
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        return left > right ? left + 1 : right + 1;
    }
    
    
}
