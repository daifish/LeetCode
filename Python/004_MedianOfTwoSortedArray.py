class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        totalLen = len(nums1) + len(nums2)
        if (1 & totalLen) : # 通过位运算判断奇偶数
            return self.findK(nums1, nums2, (totalLen + 1) / 2)
        else:
            return (self.findK(nums1, nums2, totalLen / 2) + self.findK(nums1, nums2, totalLen/2 + 1)) / 2.0
    
    def findK(self, A, B, K):
        la,lb,pa,pb = len(A),len(B),min(K/2,len(A)),K-min(K/2,len(A))
        if (la > lb):
            return self.findK(B, A, K)
        if (la == 0):
            return B[K - 1]
        if K == 1:
            return min(A[0], B[0])
        if A[pa - 1] < B[pb - 1]: return self.findK(A[pa:], B, K - pa)
        elif A[pa - 1] > B[pb - 1]: return self.findK(A, B[pb:], K - pb)
        else: return A[pa - 1]
        