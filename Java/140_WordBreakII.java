/*************************************************************************
    > File Name: 140_WordBreakII.java
    > Author: daiyu
    > Mail: 122267888@qq.com 
    > Created Time: 二 10/27 20:10:34 2015
 ************************************************************************/
public class Solution {
    ArrayList<String> result = new ArrayList<String>();
    
    public ArrayList<String> wordBreak(String s, Set<String> wordDict) {
        if (hasResult(s, wordDict)) {
            dfs(s, wordDict, "");
        }
        
        return result;
    }
    
    public boolean hasResult(String s, Set<String> dict) {
        int len = s.length();
        if (s.length() == 0 || dict.size() == 0) {
            return false;
        }
        
        boolean[] array = new boolean[s.length() + 1];
        array[0] = true;
        for (int i = 1; i <= s.length(); i ++) {
            for (int j = 0; j < i; j ++) {
                if (array[j] && dict.contains(s.substring(j, i))) {
                    array[i] = true;
                    break;
                }
            }
        }
        
        return array[len];
    }
    
    public void dfs(String subStr, Set<String> dict, String currentStr) {
        if (subStr.length() == 0) {
            result.add(currentStr);
        }
        
        for (int i = 0; i <= subStr.length(); i ++) {
            String sub = subStr.substring(0, i);
            if (dict.contains(sub)) {
                //记住当前的位置
                int subLen = currentStr.length();
                
                if (!currentStr.equals("")) {
                    currentStr += " ";
                }
                
                currentStr += sub;
                //从当前位置继续往下dfs
                dfs(subStr.substring(i), dict, currentStr);  
                //恢复currentStr，继续下一个解的求解  
                currentStr = currentStr.substring(0, subLen); 
            }
        }
    }
}
