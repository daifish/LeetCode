/*************************************************************************
    > File Name: 049_.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/anagrams/
    > Created Time: 三  9/23 22:10:53 2015
 ************************************************************************/
public class Solution {
    public ArrayList<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs);
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        
        for (int i = 0; i < strs.length; i ++) {
            String tmp = sorted(strs[i]);
            ArrayList<String> val = map.get(tmp); 
            if (val != null) {
                val.add(strs[i]);
            } else {
                val = new ArrayList<String>();
                val.add(strs[i]);
                map.put(tmp, val);
            }
        }
        
        for (String s : map.keySet()) {
            result.add(map.get(s));
        }
        
        return result;
    }
    
    public String sorted(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
}
