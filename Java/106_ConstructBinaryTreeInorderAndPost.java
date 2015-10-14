/*************************************************************************
    > File Name: 106_ConstructBinaryTreeInorderAndPost.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
    > Created Time: 三 10/14 19:56:40 2015
    demo:
    [4,2,5,1,6,3,7]
	[4,5,2,6,7,3,1]
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null && postorder == null || postorder.length == 0) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int i = 0;
        for (i = 0; i < inorder.length; i ++) {
            if (inorder[i] == postorder[postorder.length - 1]) {
                break;
            }
        }
        
        int[] new_inorder_left, new_postorder_left, new_inorder_right, new_postorder_right;
        if (i < inorder.length) {
            new_inorder_left = new int[i];
            new_postorder_left = new int[i];
            System.arraycopy(inorder, 0, new_inorder_left, 0, i);
            System.arraycopy(postorder, 0, new_postorder_left, 0, i);
            
            root.left = buildTree(new_inorder_left, new_postorder_left);
            
            new_inorder_right = new int[inorder.length - i - 1];
            new_postorder_right = new int[inorder.length - i - 1];
            System.arraycopy(inorder, i + 1, new_inorder_right, 0, inorder.length - i - 1);
            System.arraycopy(postorder, i, new_postorder_right, 0, inorder.length - i - 1);
            
            root.right = buildTree(new_inorder_right, new_postorder_right);
        }
        
        return root;
    }
}
