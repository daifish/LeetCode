class Solution:
    # @return an integer
    def reverse(self, x):
        revx = int(str(abs(x))[::-1])
        if revx > math.pow(2, 31):
            return 0
        else:
            #如果 x < y 返回 -1, 如果 x == y 返回 0, 如果 x > y 返回 1。
            return revx * cmp(x, 0)

        