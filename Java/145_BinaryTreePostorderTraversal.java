/*************************************************************************
    > File Name: 145_BinaryTreePostorderTraversal.java
    > Author: daiyu
    > Mail: 122267888@qq.com 
    > Created Time: 四 10/29 10:40:38 2015
 ************************************************************************/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *      1
 *  2       3
 */
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        
        while (!stack.empty()) {
            TreeNode temp = stack.peek();
            //prev == null is the root
            if (prev == null || prev.left == temp || prev.right == temp) {
                if (temp.left != null) {
                    stack.push(temp.left);
                } else if (temp.right != null) {
                    stack.push(temp.right);
                } else {
                    stack.pop();
                    result.add(temp.val);
                }
            } else if (temp.left == prev) {
                //左子树已出栈，判断有没有右子树，有就放入栈，没有当前节点出栈
                if (temp.right != null) {
                    stack.push(temp.right);
                } else {
                    stack.pop();
                    result.add(temp.val);
                }
            } else if (temp.right == prev) {
                //右子树已出栈，当前节点出栈即可
                stack.pop();
                result.add(temp.val);
            }
            
            prev = temp;
        }
        
        return result;
    }
}
