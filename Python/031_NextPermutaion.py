class Solution(object):
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        1：从后向前比较相邻的两个元素，直到前一个元素小于后一个元素，停止
        2：如果已经没有了前一个元素，则说明这个排列是递减的，所以这个排列是没有下一个排列的。
        比如124653
        因为我们知道4后面的元素是递减的，所以在653中从后面往前查找，找到第一个大于4的数字，这就是需要和4进行交换的数字。这里找到了5，交换之后得到的临时序列为5643.，交换后得到的643也是一个递减序列。
        """
        if not nums:
            return 
        
        idx = len(nums) - 2  
  
        # 1. find out the last wrong order  
        while idx >= 0 and nums[idx] >= nums[idx + 1]:  
            idx -= 1  
  
        # 2. swap  
        if idx >= 0:  
            i = idx + 1  
            while i < len(nums) and nums[i] > nums[idx]:  
                i += 1  
            nums[i - 1], nums[idx] = nums[idx], nums[i - 1]  
  
        # 3. reverse  
        left, right = idx + 1, len(nums) - 1  
        while left <= right:  
            nums[left], nums[right] = nums[right], nums[left]  
            left += 1  
            right -= 1  