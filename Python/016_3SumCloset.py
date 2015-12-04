class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if not len(nums):
            return 0
        
        ret = nums[0] + nums[1] + nums[2]
        nums.sort()
        for i in range(len(nums) - 2):
            j = i + 1
            k = len(nums) - 1
            while j < k:
                sum = nums[i] + nums[j] + nums[k]
                if abs(sum - target) < abs(ret - target):
                    ret = sum
                if sum < target:
                    j += 1
                elif sum > target:
                    k -= 1
                else:
                    j += 1
                    k -= 1
        return ret
                
                