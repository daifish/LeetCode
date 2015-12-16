/*************************************************************************
    > File Name: 022_GenerateParentheses.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/generate-parentheses/
    > Created Time: 五  9/18 10:43:03 2015
    采用递归树的思想，当左括号数大于右括号数时可以加左或者右括号，否则只能加左括号，当左括号数达到n时，剩下全部
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
//
public class Solution {  
    public ArrayList<String> generateParenthesis(int n) {  
        // Note: The Solution object is instantiated only once and is reused by each test case.  
        ArrayList<String> res = new ArrayList<String>();  
        generate(res, "", 0, 0, n);  
        return res;  
    }  
    public void generate(ArrayList<String> res, String tmp, int lhs, int rhs, int n)  
    {  
        if(lhs == n)  
        {  
            for(int i = 0; i < n - rhs; i++)  
            {  
                tmp += ")";  
            }  
            res.add(tmp);  
            return ;  
        }  
        generate(res, tmp + "(", lhs + 1, rhs, n);  
        if(lhs > rhs)  
            generate(res, tmp + ")", lhs, rhs + 1, n);  
    }  
}
