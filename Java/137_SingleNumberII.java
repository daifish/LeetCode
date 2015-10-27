/*************************************************************************
    > File Name: 137_SingleNumberII.java
    > Author: daiyu
    > Mail: 122267888@qq.com 
    > Created Time: 二 10/27 16:02:03 2015
 ************************************************************************/
public class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        Arrays.sort(nums);
        int i = nums.length - 1;
        
        while (i > 0) {
            if (nums[i] != nums[i - 1]) {
                return nums[i];
            }
            i = i - 3;
        }
        
        return nums[0];
    }
}
