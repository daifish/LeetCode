/*************************************************************************
    > File Name: 044_WildcardMatching.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/wildcard-matching/
    > Created Time: 三  9/23 16:13:32 2015
 ************************************************************************/
/*
(1)p[j]不是'*'。情况比较简单，只要判断如果当前s的i和p的j上的字符一样（如果有p在j上的字符是'?'，也是相同），并且res[i]==true，则更新res[i+1]为true，否则res[i+1]=false;  
(2)p[j]是'*'。因为'*'可以匹配任意字符串，所以在前面的res[i]只要有true，那么剩下的          res[i+1], res[i+2],...,res[s.length()]就都是true了。
*/
public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        
        boolean[] result = new boolean[s.length() + 1];
        result[0] = true;
        
        for (int j = 0; j < p.length(); j ++) {
            if (p.charAt(j) != '*') {
                for (int i = s.length() - 1; i >= 0; i --) {
                    result[i + 1] = result[i] && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j));
                }
            } else {
                int i = 0;
                while(i <= s.length() && !result[i])
                    i ++;
                for(; i <= s.length(); i ++) {
                    result[i] = true;
                }
            }
            
            result[0] = result[0] && p.charAt(j) == '*';
        }
        
        return result[s.length()];
    }    
    
}
