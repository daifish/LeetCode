/*
author:daiyu
time:2015-9-15
url:https://leetcode.com/problems/longest-substring-without-repeating-characters/
思路：制定一个左边界，每次判断当前字符的值是否大于左边界
如果没有，则将当前Index赋予给该字符
如果大于（即出现重复字符），更新左边界
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int leftSide = 0;
        int []temp = new int[300];
            
        for(int i = 0; i < 300; i++)
            temp[i] = -1;
        
        for (int i = 0; i < s.length(); i++) {
            if (temp[s.charAt(i)] >= leftSide) 
                leftSide = temp[s.charAt(i)] + 1;
                
            temp[s.charAt(i)] = i;
            
            if (result < i - leftSide + 1)
                result = i - leftSide + 1;
        }
        
        return result;
    }
}
//22ms
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int left = 0;
        int length = s.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int i = 0; i < length; i ++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= left) {
                left = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i), i);
            result = result > i - left + 1 ? result : i - left + 1;
        }
        
        return result;
    }
}
