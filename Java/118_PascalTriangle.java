/*************************************************************************
    > File Name: 118_PascalTriangle.java
    > Author:  daiyu
	> Url :https://leetcode.com/problems/pascals-triangle/
    > Created Time: 一 10/26 09:16:01 2015
 ************************************************************************/
public class Solution {
    public ArrayList<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        if (numRows < 0) {
            result.add(new ArrayList<Integer>(1));
            return result;
        }
        if(numRows == 0) {
            return result;
        }
        temp.add(1);
        result.add(temp);
        
        for (int n = 2; n <= numRows; n ++) {
            List<Integer> curRow = new ArrayList<Integer>();
            curRow.add(1);
            //第二行实际上是result的第一个结果，上一行是result的第0个结果
            List<Integer> preRow = result.get(n - 2);
            //遍历本行添加值
            for (int i = 1; i < n - 1; i ++) {
                curRow.add(preRow.get(i - 1) + preRow.get(i));
            }
            //最后的1
            curRow.add(1);
            result.add(curRow);
        }
        
        return result;
        
    }
}
