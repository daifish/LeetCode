class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        lp, rp = 0, len(height) - 1
        area = 0
        while lp < rp:
            area = max(area, min(height[lp], height[rp]) * (rp - lp))
            if height[lp] > height[rp]:
                rp -= 1
            else:
                lp += 1
        
        return area
            