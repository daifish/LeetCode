class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        这道题类似实现C++ 中的去重操作，大致思路是遍历一遍数组将所有重复元素取第一个依次放到数组的最前面，
        然后截取数组的前半段即可 具体实现：遍历数组，用start记录遇到的每次遇到第一个重复元素要调整到的位置：
        这里start初值为1而不是0，因为新数组的第一个元素和旧数组是一样的，用keyValue记录遇到的重复元素，遍历数组，
        每次遇到新的重复元素，则更新keyValue，然后将该元素放到start指示的位置上，然后start向后挪一位，
        最后把原数组前半段没有重复元素的部分作为新数组此时start的值就是新数组长度。
        """
        if nums == []: return 0
        start = 1
        value = nums[0]
        
        for i in range(len(nums)):
            if nums[i] != value:
                value = nums[i]
                nums[start] = nums[i]
                start += 1
        
        nums = nums[:start]
        return start
        

