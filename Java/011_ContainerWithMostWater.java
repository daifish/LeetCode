/*************************************************************************
    > File Name: 11_ContainerWithMostWater.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/container-with-most-water/ 
    > Created Time: 三  9/16 14:59:58 2015
 ************************************************************************/
public class Solution {
    public int maxArea(int[] s) {
        int max = 0;
        int area = 0;
        int left = 0;
        int right = 0;
        int i = 0;
        int j = s.length - 1;
        
        while (i < j) {
            if (left > s[i]) {
                i ++;
                continue;
            } else {
                left = s[i];
            }
            
            if (right > s[j]) {
                j --;
                continue;
            } else {
                right = s[j];
            }
            
            int tmp = s[i] - s[j] > 0 ? s[j] : s[i];
            area = tmp * (j - i);
            
            if (area > max) {
                max = area;
            }
            
            if (s[i] - s[j] > 0) {
                j--;
            } else {
                i++;
            }
        }
        
        return max;
    }
}
//8ms
public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        
        while (left < right) {
            area = Math.max(area, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right]) {
                right --;
            } else {
                left ++;
            }
        }
        
        return area;
    }
}
