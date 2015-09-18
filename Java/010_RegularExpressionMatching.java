/*************************************************************************
    > File Name: 10_RegularExpressionMatching.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/regular-expression-matching/ 
    > Created Time: 三  9/16 13:57:31 2015
    思路：
    1.the second char of pattern is "*"
	2.the second char of pattern is not "*"
	For the 1st case, if the first char of pattern is not ".", the first char of pattern and string should be the same. Then continue to match the remaining part.

	For the 2nd case, if the first char of pattern is "." or first char of pattern == the first i char of string, continue to match the remaining part.
 ************************************************************************/
public class Solution {
    public boolean isMatch(String s, String p) {
    	//如果 p的长度为0，那么 根据s.length()是否为零进行判断
        if (p.length() == 0) {
            return s.length() == 0;
        }
        //如果p的长度为1，当s的长度为0时 返回false， 如果s的长度不为0，则判断p的首字符不为'.'时s与p首字符是否相等
        //否则则认为该位字符匹配 进入下一字符判断
        if (p.length() == 1) {
            if (s.length() < 1) {
                return false;
            } 
            
            else if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
                return false;
            }
            
            else {
                //s.substring(1) means from 1 to the end eg: s = "123" s.substring(1) = "23"
                return isMatch(s.substring(1), p.substring(1));
            }
        }
        //如果p的第二位不为'*' 和上面情况一样
        if (p.charAt(1) != '*') {
            if (s.length() < 1) {
                return false;
            } 
            if ((s.charAt(0) != p.charAt(0)) && (p.charAt(0) != '.')) {
                return false;
            }
            else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }
        // 如果p的第二位为'*',则此时p的首字符和第二位的*可以不考虑，直接比较s与去掉前两位的p，*代表前一位字符出现0次或n次
        // 如果上面比较不符合，那么代表*前的字符有出现次数为1至n次，则挨位比较，即遍历s的每一位与p的首字符比较，如果有不同则直接
        // 返回false， 如果相同则判断去除当前字符的s与p
        else {
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            
            int i = 0;
            while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s.substring(1 + i), p.substring(2))) {
                    return true;
                }
                i ++;
            }
            
            return false;
        }
    }
}
