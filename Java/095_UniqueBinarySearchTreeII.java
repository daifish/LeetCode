/*************************************************************************
    > File Name: 095_UniqueBinarySearchTreeII.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/unique-binary-search-trees-ii/
    > Created Time: 二 10/13 13:42:39 2015
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
    public ArrayList<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }
    
    public ArrayList<TreeNode> generateTrees(int left, int right) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if (left > right) {
            result.add(null);
            return result;
        }
        
        for (int i = left; i <= right; i ++) {
            ArrayList<TreeNode> lefts = generateTrees(left, i - 1);
            ArrayList<TreeNode> rights = generateTrees(i + 1, right);
            
            for (int j = 0; j < lefts.size(); j ++) {
                for (int k = 0; k < rights.size(); k ++) {
                    TreeNode root = new TreeNode(i);
                    root.left = lefts.get(j);
                    root.right = rights.get(k);
                    result.add(root);
                }
            }
        }
        
        return result;
    }
}
