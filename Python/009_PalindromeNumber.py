class Solution(object):
    #@ return boolean
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        temp = x
        new_temp = 0
        
        while temp > 0:
            new_temp = new_temp * 10 + temp % 10
            temp /= 10
            
        return new_temp == x