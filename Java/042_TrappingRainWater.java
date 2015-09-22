/*************************************************************************
    > File Name: 042_TrappingRainWater.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/trapping-rain-water/
    > Created Time: 二  9/22 22:45:52 2015
 ************************************************************************/
/*
    最简单的思路，就是建立[n*最高值]的一个矩阵，遍历每一行，判断两个1之间的间距即可(i - j - 1) 即盛水量
    另种思路，从左向右看，如果递增则无法盛水，从右往左看，如果递增则无法盛水，即从左到右要递减，从右向左也要递减
    根据上面的思路找到两个边界
    判断当前两个边界值，找到较小的，如果左边较小，开始计算盛水值，需要当前位置i值大于 i + 1的值
    如果右边较小，需要当前位置i值大于i － 1的值
*/
public class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int result = 0;
        
        if (len < 3) {
            return 0;
        }
        
        while (left < right && height[left] <= height[left + 1]) left ++;
        while (left < right && height[right] <= height[right - 1]) right --;
        
        while (left < right) {
            int leftNum = height[left];
            int rightNum = height[right];
            
            if (leftNum < rightNum) {
                while (left < right && leftNum >= height[++left]) {
                    result += leftNum - height[left];
                }
            } else {
                while (left < right && height[--right] <= rightNum) {
                    result += rightNum - height[right];
                }
            }
        }
        
        return result;
        
        
    }
}
