/*************************************************************************
    > File Name: 081_SearchInRotatedSortedArrayII.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
    > Created Time: 一 10/12 15:47:11 2015
 ************************************************************************/
public class Solution {
    public boolean search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        
        while (begin < end) {
            int mid = (begin + end) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[begin] == nums[mid]) {
                for (int i = begin; i < mid; i ++) {
                    if (nums[i] == target) {
                        return true;
                    }
                }
                
                begin = mid + 1;
            } else if (nums[begin] < nums[mid]) {
                if (nums[begin] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[end]) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        
        if (begin == end && nums[begin] == target) {
            return true;
        } else {
            return false;
        }
    }
}
