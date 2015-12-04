#http://www.felix021.com/blog/read.php?2040
class Solution:
    # @return a string
    def longestPalindrome(self, s):
        t = '$#' + '#'.join(s) + '#_'
        p = [0] * 4010
        #mx为已判断回文串最右边位置，id为中间位置，mmax记录p数组中最大值 
        mx, id, mmax, right = 0, 0, 0, 0
        for i in range(1, len(t) - 1):
            if mx > i:
                p[i] = min(p[2 * id - i], mx - i)
            else:
                p[i] = 1
            while t[i + p[i]] == t[i - p[i]]:
                p[i] += 1
            if i + p[i] > mx:
                mx = i + p[i]
                id = i
            if mmax < p[i]:
                mmax = p[i]
                right = i
        return s[right//2 - mmax//2: right//2 - mmax//2 + mmax - 1]