class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        if len(nums) <= 2:
            return []
        
        ret = []
        tar = 0
        nums.sort()
        i = 0
        while i < len(nums) - 2:
            j = i + 1
            k = len(nums) - 1
            while j < k:
                if nums[i] + nums[j] + nums[k] < tar:
                    j += 1
                elif nums[i] + nums[j] + nums[k] > tar:
                    k -= 1
                else:
                    ret.append([nums[i], nums[j], nums[k]])
                    j += 1
                    k -= 1
                    #now j has + 1 -> compare nums[j] == nums[j - 1]
                    while j < k and nums[j] == nums[j - 1]:
                        j += 1
                    while j < k and nums[k] == nums[k + 1]:
                        k -= 1
            while i < len(nums) - 2 and nums[i] == nums[i + 1]:
                i += 1
            i += 1
        return ret