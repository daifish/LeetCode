/*
Input: numbers={2, 7, 11, 15}, target=9
Output: index1 = 1 index2 = 2
Url:https://leetcode.com/problems/two-sum/
Author:daiyu
Time:2015-9-15
Language:Java
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
