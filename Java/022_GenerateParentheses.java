/*************************************************************************
    > File Name: 022_GenerateParentheses.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/generate-parentheses/
    > Created Time: 五  9/18 10:43:03 2015
 ************************************************************************/
public class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> al = new ArrayList<String>();
        rec(n, 0, 0, "", al);
        return al;
    }
    
    public void rec (int n, int left, int right, String str, ArrayList<String> al) {
        if (left < right) {
            return;
        }
        
        if (left == n && right == n ) {
            al.add(str);
            return;
        }
        
        if (left == n) {
            rec(n, left, right + 1, str + ")", al);
            return;
        }
        
        rec(n, left + 1, right, str + "(", al);
        rec(n, left, right + 1, str + ")", al);
        
    }
}
