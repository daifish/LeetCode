public class Solution {
    String[] alpha = new String[] {
            " ",
            "1", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
    };
    
    StringBuilder word;

    private void dfs(List<String> res, String digits, int cur) {
        if (cur >= digits.length()) {
            res.add(word.toString());
        } else {
            for (int i = 0; i < alpha[digits.charAt(cur) - '0'].length(); ++i) {
                word.append(alpha[digits.charAt(cur) - '0'].charAt(i));
                dfs(res, digits, cur + 1);
                //将最后一位清楚，进行下一位处理
                word.deleteCharAt(word.length() - 1);
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        
        if (digits.length() == 0) {
            return ret;
        }
        
        word = new StringBuilder();
        dfs(ret, digits, 0);
        return ret;
    }
}
