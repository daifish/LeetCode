/*************************************************************************
    > File Name: 089_GrayCode.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/gray-code/
    > Created Time: 一 10/12 22:50:54 2015
 ************************************************************************/
public class Solution {
    //第n位的格雷码由两部分构成，一部分是n-1位格雷码，再加上 1<<(n-1)和n-1位格雷码的逆序的和
/*    0 0 0
    0 0 1
    0 1 1
    0 1 0
    1 1 0
    1 1 1
    1 0 1
    1 0 0
*/
    public ArrayList<Integer> grayCode(int n) {
        if (n == 0) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }
        
        ArrayList<Integer> tmp = grayCode(n - 1);
        int addNumber = 1 << (n - 1);
        ArrayList<Integer> result = new ArrayList<Integer>(tmp);
        for (int i = tmp.size() - 1; i >= 0; i --) {
            result.add(addNumber + tmp.get(i));
        }
        
        return result;
    }
}
