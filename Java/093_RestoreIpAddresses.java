/*************************************************************************
    > File Name: 093_RestoreIpAddresses.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/restore-ip-addresses/
    > Created Time: 二 10/13 10:16:12 2015
 ************************************************************************/
/*
一开始搜索1个字符和剩下的字符串，判断该字符的index是否越界了，对于剩下的字符串递归；

然后是2个字符和剩下的字符串，判断这2个字符的首字符是否是0，对于剩下的字符串递归；

然后是3个字符和剩下的字符串，判断这3个字符的首字符是否是0，并且这3个字符组成的数字是否小于等于255，对于剩下的字符串递归。

*/
public class Solution {
    ArrayList<String> result = new ArrayList<String>();
    ArrayList<Integer> candidate = new ArrayList<Integer>();
    String str = "";
    
    public ArrayList<String> restoreIpAddresses(String s) {
        
        if (s == null || s.length() > 12) {
            return result;
        }
        
        str = s;
        dfs(0);
        return result;
    }
    
    public void dfs (int index) {
        if (candidate.size() == 4 && index == str.length()) {
            add();
        }
            
        if (index >= str.length() || candidate.size() >= 4) {
            return;
        }
        
        candidate.add(Integer.parseInt(str.substring(index, index + 1)));
        dfs(index + 1);
        candidate.remove(candidate.size() - 1);
        
        if (index >= str.length() - 1 || str.substring(index, index + 1).equals("0") || candidate.size() >= 4) {
            return;
        }
        
        candidate.add(Integer.parseInt(str.substring(index, index + 2)));
        dfs(index + 2);
        candidate.remove(candidate.size() - 1);
        
        if (index >= str.length() - 2 || str.substring(index, index + 1).equals("0") || candidate.size() >= 4) {
            return;
        }
        
        if (Integer.parseInt(str.substring(index, index + 3)) <= 255) {
            candidate.add(Integer.parseInt(str.substring(index, index + 3)));
            dfs(index + 3);
            candidate.remove(candidate.size() - 1);
        }
    }
    
    public void add() {
            String ip = candidate.get(0) + "."
                    + candidate.get(1) + "."
                    + candidate.get(2) + "."
                    + candidate.get(3);
            result.add(ip);
    }
}
