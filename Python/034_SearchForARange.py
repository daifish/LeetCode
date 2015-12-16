class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        begin = -1
        end = -1
        
        for i in range(len(nums)):
            if nums[i] != target:
                continue
            else:
                begin = i
                end = i
                break
            
        for j in range(begin + 1, len(nums)):
            if nums[j] == target:
                end += 1
        
        return [begin, end]
            