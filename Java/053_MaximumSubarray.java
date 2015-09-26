/*************************************************************************
    > File Name: 053_MaximumSubarray.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/maximum-subarray/
    > Created Time: 六  9/26 18:05:48 2015
 ************************************************************************/
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        int max = nums[0];
        int cur = 0;
        
        for (int i = 0; i < len; i ++) {
            cur += nums[i];
            
            if (max < cur) {
                max = cur;
            }
            
            if (cur < 0) {
                cur = 0;
            }
        }
        
        return max;
    }
}
