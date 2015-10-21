/*************************************************************************
    > File Name: 056_.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/merge-intervals/
    > Created Time: 六  9/26 20:48:47 2015
 ************************************************************************/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 1) {
            return intervals;
        }
        
        Collections.sort(intervals, new IntervalComparator());
        List<Interval> result = new ArrayList<Interval>();
        
        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i ++) {
            Interval cur = intervals.get(i);
            
            if (prev.end >= cur.start) {
                Interval merged = new Interval(prev.start, Math.max(prev.end, cur.end));
                prev = merged;
            } else {
                result.add(prev);
                prev = cur;
            }
        }
        result.add(prev);
        
        return result;
    }
}

class IntervalComparator implements Comparator<Interval> {
    //当两个对象相等时，该方法返回0；当obj1大于obj2时，返回一个正值此时升序；否则，返回一个负值此时降序
	public int compare(Interval i1, Interval i2) {
		return i1.start - i2.start;
	}
}
