/*************************************************************************
    > File Name: 119_PascalTriangleII.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/pascals-triangle-ii/
    > Created Time: 一 10/26 09:41:12 2015
 ************************************************************************/
public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);
        
        if (rowIndex <= 0) {
            return result;
        }
        
        result.add(1);
        if (rowIndex == 1) {
            return result;
        }
        
        for (int i = 2; i <= rowIndex; i ++) {
            //添加新的一行的最后1个1
            result.add(1);
            for(int j = i - 1; j > 0; j --) {
                //生成中间的值
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }
        
        return result;
    }
}
