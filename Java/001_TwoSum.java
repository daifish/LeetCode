/*
Input: numbers={2, 7, 11, 15}, target=9
Output: index1 = 1 index2 = 2
Url:https://leetcode.com/problems/two-sum/
Author:daiyu
Time:2015-9-15
Language:Java
本题解法：暴力破解
额外的思路：1.对数组排序，从两端开始向中间靠拢，找到两者和为target即可
2.利用hashmap，将当前nums[i]的index值作为value，nums[i]作为key，存入hashmap，判断如果target－nums[i]的值存在即返回此两个hashmap
对应的值即可，如果不存在将该值与index存入hashmap
*/
public Class Solution{
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];

		for (int i = 0; i < nums.length; i ++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i + 1;
					result[1] = j + 1;
					return result;
				}
			}
		}

		return result;
	}
}
