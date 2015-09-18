/*************************************************************************
    > File Name: 028_implementStr.java
    > Author: daiyu	
	> Url: https://leetcode.com/problems/implement-strstr/
    > Created Time: 五  9/18 15:34:44 2015
 ************************************************************************/
public class Solution {
    public int strStr(String haystack, String needle) {
        int result = 0;
        int nLength = needle.length();
        int hLength = haystack.length();
        //父字符串的长度要比子串长
        if (hLength < nLength) {
            return -1;
        }
        //子串长度为0        
        if (needle.length() == 0) {
            return 0;
        }
        //双重循环，利用m作为父字符串的工作指针，i纪录结果点，保持不动
        for (int i = 0; i < hLength; i ++) {
            if (i + nLength > hLength) {
                 return -1;
            }
            
            int m = i;
            for (int j = 0; j < nLength; j ++) {
                if(needle.charAt(j) == haystack.charAt(m)){
                    if(j == needle.length() - 1)
                        return i;
                    m++;
                } else {
                    break;
                }
            }
        }      
        
        return -1;
    }
}
