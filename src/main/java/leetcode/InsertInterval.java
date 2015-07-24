package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new LinkedList<>();
		intervals.add(newInterval);
		class Cmp implements Comparator<Interval> {
			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.start < o2.start) {
					return -1;
				} else if (o1.start == o2.start) {
					return 0;
				} else {
					return 1;
				}
			}
		}
		Collections.sort(intervals, new Cmp());
		result.add(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			Interval previous = result.get(result.size() - 1);
			Interval current = intervals.get(i);
			// no overlap
			if (previous.end < current.start) {
				result.add(current);
			} else {
				previous.end = Math.max(previous.end, current.end);
			}
		}
		return result;
	}

	public class Solution {
		public List<Interval> insert2(List<Interval> intervals,
				Interval newInterval) {
			if(intervals.size() == 0) {
				intervals.add(newInterval);
				return intervals;
			}
			Interval prev = intervals.get(0);
			for(int i = 1; i < intervals.size(); i++) {
				Interval curr = intervals.get(i);
				if(newInterval.start < curr.start) {
					if(newInterval.start > prev.end) {
						while(curr.end < newInterval.end && i < intervals.size()) {
							i++;
							curr = intervals.get(i);
						}
					} else {
						
					}
					break;
				}
			}
			return intervals;
		}
		
	    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	        List<Interval> res = new ArrayList<>(intervals.size());
			if(intervals.size() == 0) {
				intervals.add(newInterval);
				return intervals;
			}
	        Interval prev = null;
	        int i = 0;
	        for(i = 0; i < intervals.size(); i++) {
	        		Interval curr = intervals.get(i);
	        		if(newInterval.start < curr.start) {
	        			if(i > 0 && newInterval.start <= intervals.get(i - 1).end) {
	        				prev = intervals.get(i - 1);
	        				prev.end = Math.max(prev.end, newInterval.end);
	        			} else {
	        				res.add(newInterval);
	        				prev = newInterval;
	        			}
	        			break;
	        		}
	        		res.add(curr);
	        		prev = curr;
	        }
			while(i < intervals.size()) {
				Interval curr = intervals.get(i++);
				if(curr.start > prev.end) {
					res.add(curr);
					prev = curr;
				} else {
					prev.end = Math.max(prev.end, curr.end);
				}
			}
	        if(newInterval.start <= prev.end) {
	            prev.end = Math.max(prev.end, newInterval.end);
	        } else
	            res.add(newInterval);
	        return res;
	    }
	}
}
