/*************************************************************************
    > File Name: 080_RemoveDuplicatesFromSortedArrayII.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/ 
    > Created Time: 一 10/12 15:48:20 2015
 ************************************************************************/
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int key = nums[0];
        int count = 0;
        int start = 0;
        
        for (int i = 0; i < nums.length; i ++) {
            if (key == nums[i]) {
                count ++;
            } else {
                for (int j = 0; j < min(2, count); j ++) {
                    nums[start ++] = key;
                }
                key = nums[i];
                count = 1;
            }
        }
        
        for (int j = 0; j < min(2, count); j ++) {
            nums[start ++] = key;
        }
        
        return start;
        
    }
    
    public int min(int i, int j) {
        return i >= j ? j : i;
    }
}
