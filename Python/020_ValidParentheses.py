class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        mp = {')': '(', ']': '[', '}': '{'} 
        res = []
        for ch in s:
            if ch in '([{':
                res.append(ch)
            else:
                if not res or mp[ch] != res.pop():
                    return False
        
        return not res