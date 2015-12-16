class Solution(object):
    def DFS(self, candidates, target, start, valuelist):
        length = len(candidates)
        if target == 0:
            return Solution.ret.append(valuelist)
        for i in range(start, length):
            if target < candidates[i]:
                return
            self.DFS(candidates, target - candidates[i], i, valuelist + [candidates[i]])
        
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        candidates.sort()
        Solution.ret = []
        self.DFS(candidates, target, 0, [])
        return Solution.ret
  
        