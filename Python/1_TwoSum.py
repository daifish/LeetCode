class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        :author: daiyu
        :time :2015-9-15
        :url: https://leetcode.com/problems/two-sum/
        """
        process = {}
        
        for index in range(len(nums)):
        #判断如果target － 当前值在字典中，那么返回这个结果值的value 与此时的Index值
            if target - nums[index] in process: 
                return [process[target-nums[index]] + 1, index + 1]
            #如果不在，则将该值与对应索引存入字典中
            process[nums[index]] = index
