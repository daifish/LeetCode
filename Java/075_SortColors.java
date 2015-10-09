/*************************************************************************
    > File Name: 075_SortColors.java
    > Author: daiyu
	> Url: https://leetcode.com/problemset/algorithms/
    > Created Time: 五 10/ 9 22:07:01 2015
 ************************************************************************/
/*
类似快速排序的思想，只是需要采用三个指针来将数组自然的划分为三份。
*/
public class Solution {
    public void sortColors(int[] nums) {
        int r = -1;
        int len = nums.length;
        
        for (int i = 0; i < len; i ++) {
            if (nums[i] == 0) {
                swap(nums, ++r, i);
            } else if (nums[i] == 2) {
                swap(nums, --len, i);
                i--;
            }
        }
        
    }
    
    public void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
