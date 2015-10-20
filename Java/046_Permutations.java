/*************************************************************************
    > File Name: 046_.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/permutations/
    > Created Time: 三  9/23 22:10:38 2015
 ************************************************************************/
public class Solution {
    ArrayList<List<Integer>> result;
    
    public ArrayList<List<Integer>> permute(int[] nums) {
        result = new ArrayList<List<Integer>>();
        
        if (nums.length == 0 || nums == null) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            result.add(tmp);
            return result;
        }
        
        helper (0, nums, result);
        
        return result;
    }
    
    public void helper (int i, int[] nums, ArrayList<List<Integer>> result) {
        if (i == nums.length) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j ++) {
                tmp.add(nums[j]);
            }
            result.add(tmp);
            return;
        }
        
        for (int j = i; j < nums.length; j ++) {
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
            helper (i + 1, nums, result);
            tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
        }
    }
}
