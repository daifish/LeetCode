class Solution(object):
    def combinationSum2(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        Solution.res = []
        candidates.sort()
        self.dfs(candidates,0,0,target,[])
        return Solution.res
        
    def dfs(self,candidates,index,s,target,solu):
        if s>target: return
        if s==target:
            return Solution.res.append(solu)
        while index < len(candidates):
            self.dfs(candidates,index+1,s+candidates[index],target,solu+[candidates[index]])
            while index<len(candidates)-1 and candidates[index]==candidates[index+1]:
                index+=1
            index+=1
        return

      