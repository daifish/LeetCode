/*************************************************************************
    > File Name: 151_ReverseWordsInAString.java
    > Author: daiyu
    > Mail: 122267888@qq.com 
    > Created Time: 四 10/29 14:53:30 2015
 ************************************************************************/
public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        return helper(s,0).toString();
    }
    
    private StringBuilder helper(String s, int index) {
        if(index>=s.length())
            return new StringBuilder(); 
        StringBuilder cur = new StringBuilder();
        int lastIndex = index;
        while(index < s.length() && s.charAt(index)!=' ')
        {
            cur.append(s.charAt(index++));
        }
        while(index < s.length() && s.charAt(index)==' ')
            index++;
        if(lastIndex == 0)
            return helper(s,index).append(cur);
        return helper(s,index).append(cur).append(' ');
    }
}
