/*************************************************************************
    > File Name: 098_ValidateBinarySearchTree.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/validate-binary-search-tree/
    > Created Time: 三 10/14 16:18:37 2015
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
    //中序遍历，符合中序遍历即可
    List<Integer> list = new ArrayList<Integer>();
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        } else if (root.left == null && root.right == null) {
            return true;
        }
        inOrderTraveral(root);
        for (int i = 1; i < list.size(); i ++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
    
    public void inOrderTraveral(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraveral(root.left);
        list.add(root.val);
        inOrderTraveral(root.right);
    }
}
