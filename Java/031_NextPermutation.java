/*************************************************************************
    > File Name: 031_NextPermutation.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/next-permutation/
    > Created Time: 一  9/21 15:20:17 2015
 ************************************************************************/
/*
观察数列会发现，如果数列是递减的话我们是找不出比他更大的数列的，
所以我们要找到两个递增元素，即从右到左找到第一个左边小于右边的元素，然后我们再找出该元素右边比他大的最小的元素，交换两数，
然后再将该数后面的数列reverse()即可。
*/
public class Solution {
    public void nextPermutation(int[] nums) {
        int pos = -1;
        //从右向左找到第一个左边小于右边的元素的位置并纪录
        for (int i = nums.length - 1; i > 0; i --) {
            if (nums[i] > nums[i - 1]) {
                pos = i - 1;
                break;
            }
        }
        //降序，直接翻转就可以
        if (pos < 0) {
            reverse (nums, 0 , nums.length - 1);
            return;
        }
        //从右向左找到 比pos位置最小的元素 并交换
        for (int i = nums.length - 1; i > pos; i --) {
            if (nums[i] > nums[pos]) {
                int tmp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = tmp;
                break;
            }
        }
        
        reverse (nums, pos + 1, nums.length - 1);
    }
    
    public void reverse (int[] nums, int begin, int end) {
        int left = begin;
        int right = end;
        
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left ++;
            right --;
        }
    }
}
