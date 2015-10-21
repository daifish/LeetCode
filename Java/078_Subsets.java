/*************************************************************************
    > File Name: 078_Subsets.java
    > Author: daiyu
	> Url: https://leetcode.com/problems/subsets/
    > Created Time: 五 10/ 9 22:50:39 2015
 ************************************************************************/
/*
首先对数组排序
接下来对数组进行遍历，遍历的过程中先将上次结果集的集合加入新的结果集
再将当前遍历到的数组值加到结果集合
再将单独便利的数组值加到结果集合中
结果集更新
遍历完成后，添加空集
demo：1，2，3
第一次遍历添加［1］到结果集
第二次遍历先添加［1］到临时结果集，将2添加到［1］中，形成［1，2］，再单独生成［2］，将［1，2］［2］加到结果集中
第三次遍历将3添加到［1］、［2］、［1，2］中，即［1，3］、［2，3］、［1，2，3］，再单独生成［3］
生成结果［1］［2］［3］［1，2］［1，3］［2，3］［1，2，3］
再添加空集
*/
public class Solution {
    public ArrayList<List<Integer>> subsets(int[] S) {
	if (S == null)
		return null;
 
	Arrays.sort(S);
 
	ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
 
	for (int i = 0; i < S.length; i++) {
		ArrayList<List<Integer>> temp = new ArrayList<List<Integer>>();
 
		//get sets that are already in result
		for (List<Integer> a : result) {
			temp.add(new ArrayList<Integer>(a));
		}
 
		//add S[i] to existing sets
		for (List<Integer> a : temp) {
			a.add(S[i]);
		}
 
		//add S[i] only as a set
		ArrayList<Integer> single = new ArrayList<Integer>();
		single.add(S[i]);
		temp.add(single);
 
		result.addAll(temp);
	}
 
	//add empty set
	result.add(new ArrayList<Integer>());
 
	return result;
    }
}
