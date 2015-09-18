/*************************************************************************
    > File Name: 027_RemoveElement.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/remove-element/
    > Created Time: 五  9/18 14:41:54 2015
 ************************************************************************/
public class Solution {
    public int removeElement(int[] nums, int val) {
    	// 纪录要去除的个数
        int removeCount = 0;
        
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == val) {
                removeCount ++;
            } else {
            	//这个地方 很重要，从当前位数 减去 要去除的位数
                nums[i - removeCount] = nums[i];
            }
        }
        
        return nums.length - removeCount;
    }
}
