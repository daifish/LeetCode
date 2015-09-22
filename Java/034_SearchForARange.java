/*************************************************************************
    > File Name: 034_SearchForARange.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/search-for-a-range/
    > Created Time: 二  9/22 09:41:09 2015
 ************************************************************************/
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int []result = {-1, -1};
        Boolean first = true;
        
        if (nums.length == 0) {
            return result;
        }
        
        if (nums.length == 1 && nums[0] == target) {
            result[0] = 0;
            result[1] = 0;
            return result;
        }
        
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == target && first) {
                result[0] = i;
                result[1] = i;
                first = false;
            } else if (nums[i] == target) {
                result[1] = i;
                continue;
            } else if (nums[i] < target){
                continue;
            } else {
                break;
            }
        }
        
        return result;
    }
}
