class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        result = 0
        h = len(haystack)
        n = len(needle)
        
        if h < n:
            return -1
        
        if n == 0:
            return 0
            
        for i in range(h):
            if i + n > h:
                #此时剩余子串字符串以不足作为一个子字符串，返回-1
                return -1
            
            tmp = i
            for j in range(n):
                if needle[j] == haystack[tmp]:
                    if j == n - 1:
                        return i
                    tmp += 1
                else:
                    break
                
        return -1