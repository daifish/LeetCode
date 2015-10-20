public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
        
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                int k = j + 1;
                int l = nums.length - 1;
                
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum > target) {
                        l --;
                    } else if (sum < target) {
                        k ++;
                    } else if (sum == target) {
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        tmp.add(nums[l]);
                        
                        if (!hashSet.contains(tmp)) {
                            hashSet.add(tmp);
                            result.add(tmp);
                        }
                        
                        k ++;
                        l --;
                    }
                }
            }
        }
        return result;
    }
}