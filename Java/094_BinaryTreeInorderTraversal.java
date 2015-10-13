/*************************************************************************
    > File Name: 094_BinaryTreeInorderTraversal.java
    > Author: daiyu
	> url: https://leetcode.com/problems/binary-tree-inorder-traversal/
    > Created Time: 二 10/13 10:43:53 2015
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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        
        while(!stack.empty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {//dont have left child pop then to the right;
                TreeNode t = stack.pop();
                result.add(t.val);
                p = t.right;
            }
        }
        
        return result;
    }
}
