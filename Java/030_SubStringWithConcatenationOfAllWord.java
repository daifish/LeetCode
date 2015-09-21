/*************************************************************************
    > File Name: 030_SubStringWithConcatenationOfAllWord.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/substring-with-concatenation-of-all-words/
    > Created Time: 一  9/21 10:39:19 2015
 ************************************************************************/
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        //字符串数组求长度是.length 字符串则是.length()
        List<Integer> list = new ArrayList<Integer>();
        if (s.length() < 1 || words.length < 1) return list;
        int len = words[0].length();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i = 0; i < words.length; i ++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }
        
        for (int i = 0; i <= s.length() - words.length * len; i ++) {
            int begin = i;
            int num = 0;
            String str = s.substring(begin, begin + len);
            
            while (map.containsKey(str) && map.get(str) > 0) {
                map.put(str, map.get(str) - 1);
                num ++;
                begin += len;
                //越界处理
                if (begin + len > s.length()) break;
                str = s.substring(begin, begin + len);
            }
            
            if (num == words.length) {
                list.add(i);
            }
            
            if (num > 0) {
                map.clear();
                for (int j = 0; j < words.length; j ++) {
                    if (map.containsKey(words[j])) {
                        map.put(words[j], map.get(words[j]) + 1);
                    } else {
                        map.put(words[j], 1);
                    }
                }
            }
        }
        
        return list;
    }
}
