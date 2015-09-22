/*************************************************************************
    > File Name: 039_CombinationSum.java
    > Author: daiyu
	> Url :
    > Created Time: 二  9/22 15:49:20 2015
 ************************************************************************/
public class Solution {
    List<List<Integer>> result;
    List<Integer> list;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        list = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, 0);
        return result;
    }
    
    public void helper(int[] candidates, int target, int sum, int num) {
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
            helper(candidates, target, sum, i);
            list.remove(list.size() - 1);
            sum -= candidates[i];
        }
    }
}
