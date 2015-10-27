/*************************************************************************
    > File Name: 139_WordBreak.java
    > Author: daiyu
    > Mail: 122267888@qq.com 
    > Created Time: 二 10/27 18:05:51 2015
 ************************************************************************/
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] arrays = new boolean[len + 1];
        arrays[0] = true;
        
        for (int i = 1; i <= len; i ++) {
            for (int j = 0; j < i; j ++) {
                if (arrays[j] && wordDict.contains(s.substring(j, i))) {
                    arrays[i] = true;
                    break;
                }
            }
        }
        
        return arrays[len];
    }
}
