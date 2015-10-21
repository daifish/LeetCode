/*************************************************************************
    > File Name: 102_.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/binary-tree-level-order-traversal/
    > Created Time: 三 10/14 18:47:55 2015
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
    public ArrayList<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int num;
        if (root == null) {
            return result;
        }
        //queue.offer添加元素
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            num = queue.size();
            tmp.clear();
            for (int i = 0; i < num; i ++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                } 
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            
            result.add(new ArrayList<Integer>(tmp));
        }
        return result;
    }
}
