class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        alpha = [" ", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"] 
        res = []
        word = []
        
        def dfs(cur):
            if cur >= len(digits):
                res.append(''.join(word))
            else:
                for x in alpha[(int)(digits[cur]) - (int)('0')]:
                    word.append(x)
                    dfs(cur + 1)
                    word.pop()
                    
        if len(digits) == 0:        
            return res
        else:
            dfs(0)
            return res