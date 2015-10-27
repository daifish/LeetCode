/*************************************************************************
    > File Name: 134_GasStation.java
    > Author: daiyu
    > Mail: 122267888@qq.com 
    > Created Time: 二 10/27 15:40:39 2015
 ************************************************************************/
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int total = 0;
        int j = -1;
        for (int i = 0; i < gas.length; i ++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (sum < 0) {
                j = i;
                sum = 0;
            }
        }
        if (total < 0) {
             //所有加油站的油量都不够整个路程的消耗 
            return -1;
        } else {
            return j + 1;
        }
    }
}
