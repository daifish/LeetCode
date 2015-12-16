class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        def rec(n, left, right, tmp, result):
            if left < right:
                return
            
            if left == n and right == n:
                result.append(tmp);
                return
            
            if left == n:
                rec(n, left, right + 1, tmp + ")", result)
                return
            
            rec(n, left + 1, right, tmp + "(", result)
            rec(n, left, right + 1, tmp + ")", result)
        
        result = []
        rec(n, 0, 0, "", result)
        return result;
        
        
            