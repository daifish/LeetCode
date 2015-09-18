/*************************************************************************
    > File Name: 15_3Sum.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/3sum/
    > Created Time: 三  9/16 17:33:04 2015
    思路：那么我们不妨先对数组排个序。排序之后，我们就可以对数组用两个指针分别从前后两端向中间扫描了
    如果是 2Sum，我们找到两个指针之和为target就OK了，那 3Sum 类似，我们可以先固定一个数，然后找另外两个数之和为第一个数的相反数就可以了。
 ************************************************************************/
public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3 || nums == null) {
            return result;
        }
        
        Arrays.sort(nums);
        
        int length = nums.length;
        
        for (int i = 0; i < length - 2; i ++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            } 
            
            find(nums, i + 1, length - 1, nums[i]);
        }
        
        return result;
    }
    
    public void find (int[] nums, int begin, int end, int target) {
        int left = begin;
        int right = end;
        
        while (left < right) {
            if (nums[left] + nums[right] + target == 0) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(target);
                list.add(nums[left]);
                list.add(nums[right]);
                result.add(list);
                
                while (left < right && nums[left] == nums[left + 1]) {
                    left ++;
                }
                while (left < right && nums[right] == nums[right - 1]) {
                    right --;
                }
                
                left ++;
                right --;
            }
            
            else if (nums[left] + nums[right] + target < 0) {
                left ++;
            }
            
            else {
                right --;
            }
        }
    }
}
