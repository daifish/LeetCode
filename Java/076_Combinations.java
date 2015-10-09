/*************************************************************************
    > File Name: 076_Combinations.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/combinations/
    > Created Time: 五 10/ 9 22:26:49 2015
 ************************************************************************/
/*
用DFS(参考Work BreakII)的循环递归处理子问题的方法解决。n为循环的次数，k为每次尝试的不同数字。用到了回溯
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> item = new ArrayList<Integer>();
        
        if (n < 0 || n < k) {
            return null;
        }
        
        dfs(n, k, 1, item, result);
        return result;
    }
    
    private void dfs(int n, int k, int start, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> result) {
        if (item.size() == k) {
            result.add(new ArrayList<Integer>(item));
            return;
        }
        
        for (int i = start; i < n; i ++) {
            item.add(i);
            dfs(n, k, start + 1, item, result);
            item.remove(item.size() - 1);
        }
    }
}
