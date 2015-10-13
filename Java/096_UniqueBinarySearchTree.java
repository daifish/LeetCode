/*************************************************************************
    > File Name: 096_UniqueBinarySearchTree.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/unique-binary-search-trees/
    > Created Time: 二 10/13 13:44:01 2015
 ************************************************************************/
public class Solution {
    public int numTrees(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        // 如果n大于3时，根节点有n种选择，确定根节点后分别计算左右子树的可能情况，然后相乘就是当前根节点下所有的变形种类，之后在求和即可
        for (int i = 2; i <= n; i ++) {
            for (int j = 0; j <= i - 1; j ++) {
                result[i] += result[j] * result[i - j - 1];
            }
        }
        
        return result[n];
    }
}
