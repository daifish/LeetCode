/*************************************************************************
    > File Name: 152_MaximumProductsSubarray.java
    > Author: daiyu
    > Mail: 122267888@qq.com 
    > Created Time: 四 10/29 15:14:41 2015
 ************************************************************************/
public class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        
        for (int i = 1; i < nums.length; i ++) {
            int a = nums[i] * max;
            int b = nums[i] * min;
            max = Math.max(Math.max(a, b), nums[i]);
            min = Math.min(Math.min(a, b), nums[i]);
            result = Math.max(result, max);
        }
        
        return result;
    }
}
