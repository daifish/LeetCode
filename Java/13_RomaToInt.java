/*************************************************************************
    > File Name: 13_RomaToInt.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/roman-to-integer/
    > Created Time: 三  9/16 16:32:58 2015
 ************************************************************************/
public class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int sub = getRomanValue(s.charAt(0));
        int lastv = sub;
     
        if (s.length() < 1) {
            return 0;
        }
        
        for (int i = 1; i < s.length(); i++) {
            char curc = s.charAt(i);
            int curv = getRomanValue(curc);
            
            if (lastv == curv) {
                sub += lastv;
            }
            
            else if (lastv > curv) {
                result += sub;
                sub = curv;
            }
            
            else {
                sub = curv - sub;
            }
            
            lastv = curv;
        }
        
        result += sub;
        return result;
        
    }    
    public static int getRomanValue(char c) {  
        switch(c) {  
            case 'I': return 1;   
            case 'V': return 5;  
            case 'X': return 10;  
            case 'L': return 50;  
            case 'C': return 100;  
            case 'D': return 500;  
            case 'M': return 1000;  
            default: return 0;  
        }  
    }  
}
