/*************************************************************************
    > File Name: 038_CountAndSay.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/count-and-say/
    > Created Time: 二  9/22 14:03:43 2015
 ************************************************************************/
public class Solution {
    public String countAndSay(int n) {
        String str = "1";
        int i = 1;
        
        while (i < n) {
            str = helper(str);
            i ++;
        }

        return str;
    }
    
    public String helper(String str) {
        char tmp = str.charAt(0);
        int num = 1;
        StringBuffer sb = new StringBuffer("");
        
        for (int i = 1; i < str.length(); i ++) {
            if (str.charAt(i) == tmp) {
                num ++;
                continue;
            }
            
            sb.append(Integer.toString(num) + tmp);
            tmp = str.charAt(i);
            num = 1;
        }
        
        sb.append(Integer.toString(num) + tmp);
        
        return sb.toString();
    }
}
