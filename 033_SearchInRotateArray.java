/*************************************************************************
    > File Name: 033_SearchInRotateArray.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/search-in-rotated-sorted-array/
    > Created Time: 二  9/22 09:27:44 2015
 ************************************************************************/
public class Solution {
    public int search(int[] nums, int target) {
        int result = -1;
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } 
            
            if (nums[left] <= nums[right]) {
                if (target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] <= nums[mid]) {
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        
        
        return result;
    }
}
