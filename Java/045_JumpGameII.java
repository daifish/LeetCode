/*************************************************************************
    > File Name: 045_JumpGameII.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/jump-game-ii/
    > Created Time: 三  9/23 16:54:30 2015
 ************************************************************************/
/*
我们维护一个到目前为止能跳到的最远距离，以及从当前一步出发能跳到的最远距离。局部最优local=A[i]+i，而全局最优则是global=Math.max(global, local)。
*/
public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int maxcover = 0;
        int lastcover = 0;//step - 1步所能到的最远距离
        int step = 0;
        
        for (int i = 0; i <= maxcover &&  i < nums.length; i ++) {
            if (i > lastcover) {// 此时已经超过step上一步能到达的最远距离 step ＋ 1
                step ++;
                lastcover = maxcover;
            } 
            
            if (nums[i] + i > maxcover) {
                maxcover = nums[i] + i;
            }
        }
        
        if (maxcover < nums.length - 1)
            return 0;
        
        return step;
    }
    
}
