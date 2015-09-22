/*************************************************************************
    > File Name: 035_SearchInsertPosition.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/search-insert-position/
    > Created Time: 二  9/22 09:50:52 2015
 ************************************************************************/
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int result = 0;
        
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] >= target) {
                return i;
            } else {
                result += 1;
                continue;
            }
        }
        
        
        return result;
    }
}
