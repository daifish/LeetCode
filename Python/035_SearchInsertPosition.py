class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        index = 0
        for i in range(len(nums)):
            if nums[i] < target:
                continue
            else:
                index = i
                break
        # 如果所有的值都小于target
        if nums[len(nums) - 1] < target:
            index = len(nums)
            
        return index
                