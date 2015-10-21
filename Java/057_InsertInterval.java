/*************************************************************************
    > File Name: 057_.java
    > Author: daiyu
	> Url : https://leetcode.com/problems/insert-interval/
    > Created Time: 六  9/26 20:48:53 2015
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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || newInterval == null) {
            return null;
        }
        
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        
        ListIterator<Interval> it = intervals.listIterator();
        while(it.hasNext()) {
            Interval tmp = it.next();
            if (newInterval.end < tmp.start) {
                //找到插入位置
                it.previous();
                it.add(newInterval);
                return intervals;
            } else {
                if (tmp.end < newInterval.start) {
                    //当前的节点的end比要插入的值的start小
                    //比如tmp为［1，2］， 要插入的值为［3，5］则继续遍历
                    continue;
                } else {
                    newInterval.start = Math.min(tmp.start, newInterval.start);
                    newInterval.end = Math.max(tmp.end, newInterval.end);
                    it.remove();
                }
            }
        }
        intervals.add(newInterval);
        return intervals;
    }
}
