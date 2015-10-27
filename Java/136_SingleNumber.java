/*************************************************************************
    > File Name: 136_SingleNumber.java
    > Author: daiyu
    > Mail: 122267888@qq.com 
    > Created Time: 二 10/27 15:58:13 2015
 ************************************************************************/
public class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        
        int i = nums.length - 1;
        
        Arrays.sort(nums);
        
        while (i > 0) {
            if (nums[i] != nums[i - 1]) {
                return nums[i];
            }
            i = i - 2;
        }
        
        return nums[0];
    }
}
