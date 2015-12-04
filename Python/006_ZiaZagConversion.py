class Solution:
    # @return a string
    def convert(self, s, nRows):
        if nRows == 1:
            return s
        step = nRows * 2 - 2
        # first row
        ret = s[::step]
        for i in range(1, nRows - 1):
            for j in range(i, len(s), step):
                ret += s[j]
                if j + (step - i * 2) < len(s):
                    ret += s[j + (step - i * 2)]
        # last row
        ret += s[nRows - 1::step]
        return ret

        