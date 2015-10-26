/*************************************************************************
    > File Name: 129_SumRootToLeafNumbers.java
    > Author: daiyu
    > Mail: 122267888@qq.com 
    > Created Time: 一 10/26 15:26:17 2015
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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        help (root, 0);
        
        return sum;
    }
    
    public void help (TreeNode root, int num) {
        num = root.val + 10 * num;
        
        if (root.left == null && root.right == null) {
            sum += num;
        }
        
        if (root.left != null) {
            help (root.left, num);
        }
        
        if (root.right != null) {
            help (root.right, num);
        }
    }
}
