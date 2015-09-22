/*************************************************************************
    > File Name: 041_FirstMissingPositive.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/first-missing-positive/
    > Created Time: 二  9/22 21:59:26 2015
 ************************************************************************/
/*
    保证 第i个位置存的是i + 1即可
    相似问题：n个元素的数组，里面的数都是0~n-1范围内的，求数组中重复的某一个元素，没有返回-1, 要求时间性能O(n) 空间性能O(1)
*/

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;        
        int pos = 0;
        
        while (pos < len) {
            if (nums[pos] > 0 && nums[pos] != pos + 1 && nums[pos] - 1 < len && nums[pos] != nums[nums[pos] - 1]) {
                int temp = nums[pos];
                nums[pos] = nums[temp - 1];
                nums[temp - 1] = temp;
            } else {
                pos ++;
            }
        }        
        
        for (int i = 0; i < len; i ++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        return len + 1;
    }
    
}
