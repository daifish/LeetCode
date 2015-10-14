/*************************************************************************
    > File Name: 105_ConstructBinaryTreePreAndInorder.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    > Created Time: 三 10/14 19:33:28 2015
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null && inorder == null || preorder.length == 0) {
            return null;
        }
        //前序的第一个元素为根元素
        TreeNode root = new TreeNode(preorder[0]);
        int i = 0;
        for (i = 0; i < inorder.length; i ++) {
            if (inorder[i] == preorder[0]) {
                break;//找到了根元素
            }
        }
        //System.arraycopy()复制数组
        //第一个参数是给定的数组，第二个参数是从给定数组的第i位开始复制
        //第三个参数是复制目标数组，第四个参数是复制目标数组的第i位开始复制
        //第五个参数为复制长度
        int[] new_inorder_left, new_preorder_left, new_inorder_right, new_preorder_right;
        if (i < inorder.length) {
            new_inorder_left = new int[i];
            new_preorder_left = new int[i];
            System.arraycopy(inorder, 0, new_inorder_left, 0, i);
            System.arraycopy(preorder, 1, new_preorder_left, 0, i);
            
            root.left = buildTree(new_preorder_left, new_inorder_left);
            
            new_inorder_right = new int[preorder.length - i - 1];
            new_preorder_right = new int[preorder.length - i - 1];
            System.arraycopy(inorder, i + 1, new_inorder_right, 0, preorder.length - i - 1);
            System.arraycopy(preorder, i + 1, new_preorder_right, 0, preorder.length - i - 1);
            
            root.right = buildTree(new_preorder_right, new_inorder_right);
        }
        
        return root;
    }
}
