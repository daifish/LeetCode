/*************************************************************************
    > File Name: 040_CombinationSumII.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/combination-sum-ii/
    > Created Time: 二  9/22 19:37:03 2015
 ************************************************************************/
public class Solution {
    List<List<Integer>> result;
    List<Integer> list;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        list = new ArrayList<>();
        
        Arrays.sort(candidates);
        helper(candidates, target, 0, 0);
        return result;
    }
    
    public void helper (int[] candidates, int target, int sum, int num) {
        if (sum > target) {
            return;
        }
        
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = num; i < candidates.length; i ++) {
            sum += candidates[i];
            list.add(candidates[i]);
            helper(candidates, target, sum, i + 1);
            list.remove(list.size() - 1);
            sum -= candidates[i];
            
            while ((i < candidates.length - 1) && candidates[i] == candidates[i + 1]) {
                i ++;
            } 
        }
    }
}
