class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        val = [  
            1000, 900, 500, 400,  
            100, 90, 50, 40,  
            10, 9, 5, 4,  
            1  
            ]  
        syb = [  
            "M", "CM", "D", "CD",  
            "C", "XC", "L", "XL",  
            "X", "IX", "V", "IV",  
            "I"  
            ]  
        roman = ''
        i = 0
        while num > 0:
            # for x in ， 有时候中间那个变量后面并不会用到 for _ in xxx
            # a // b结果四舍五入 
            for _ in range(num // val[i]):
                roman += syb[i]
                num -= val[i]
            i += 1
        return roman