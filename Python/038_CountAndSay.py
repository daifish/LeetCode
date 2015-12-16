class Solution(object):
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        result = "1"
        for i in range(n - 1):
            tmp = result
            result = ""
            cnt = 1
            for j in range(1, len(tmp)):
                if tmp[j] == tmp[j - 1]:
                    cnt += 1
                else:
                    result += ("%d"%cnt + tmp[j - 1])
                    cnt = 1
            result += ("%d"%cnt + tmp[len(tmp)-1])
            
        return result
                
            