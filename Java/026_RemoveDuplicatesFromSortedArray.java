/*************************************************************************
    > File Name: 26_RemoveDupicatesFromSortedArray.java
    > Author: daiyu	
	> Url: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    > Created Time: 五  9/18 11:38:09 2015
 ************************************************************************/
public class Solution {
    public int removeDuplicates(int[] nums) {
        int start = 0;
        
        if (nums.length == 0) {
            return start;
        }
        
        for (int i = 1; i < nums.length; i ++) {
            if (nums[start] != nums[i]) {
                nums[++start] = nums[i];
            }
        }
        
        return start + 1;
    }
}
