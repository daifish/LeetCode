/*************************************************************************
    > File Name: 144_BinaryTreePreorderTraversal.java
    > Author: daiyu
    > Mail: 122267888@qq.com 
    > Created Time: 四 10/29 10:01:56 2015
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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //stack is push, not put
        stack.push(root);
        
        while (!stack.empty()) {
            //node : stack is pop(), not poll()
            TreeNode temp = stack.pop();
            
            result.add(temp.val);
            
            if (temp.right != null) {
                stack.push(temp.right);
            }
            
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        
        return result;
    }
}
