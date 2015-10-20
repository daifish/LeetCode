/*************************************************************************
    > File Name: 047_.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/permutations-ii/
    > Created Time: 三  9/23 22:10:45 2015
 ************************************************************************/
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> item = new ArrayList<Integer>();
        
        if (nums.length == 0 || nums == null) {
            return result;
        }
        
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        help (nums, result, item, visited);
        return result;
    }
    
    public void help (int[] nums, ArrayList<List<Integer>> result, ArrayList<Integer> item, boolean[] visited) {
        if (item.size() == nums.length) {
            result.add(new ArrayList<Integer>(item));
            return;
        }  
        
        for (int i = 0; i < nums.length; i ++) {
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                item.add(nums[i]);
                visited[i] = true;
                help (nums, result, item, visited);
                item.remove(item.size() - 1);
                visited[i] = false;
            }
        }
    }
}
