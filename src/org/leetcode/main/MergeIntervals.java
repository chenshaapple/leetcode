package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new LinkedList<>();
		if(intervals == null || intervals.size() == 0) {
			return result; 
		}
		
		List<Interval> buf = new LinkedList<>(intervals);
		class Cmp implements  Comparator<Interval> {
			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.start < o2.start) {
					return -1;
				} else if(o1.start == o2.start) {
					return 0;
				} else {
					return 1;
				}
			}
		}
		Collections.sort(buf, new Cmp());
		result.add(buf.get(0));
		for(int i = 1; i < buf.size(); i++) {
			Interval previous = result.get(result.size() - 1);
			Interval current = buf.get(i);
			if(previous.end < current. start) {
				result.add(current);
			} else {
				previous.end = Math.max(previous.end, current.end);
			}
		}
		return result;
	}
	public class Solution {
	    public List<Interval> merge(List<Interval> intervals) {
	    		if(intervals.size() == 0)
	    			return intervals;
	        List<Interval> res = new LinkedList<>();
	        Collections.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.start));
	        res.add(intervals.get(0));
	        for(int i = 1; i < intervals.size(); i++) {
	        		Interval curr = intervals.get(i);
	        		Interval prev = res.get(res.size() - 1);
	        		if(prev.end < curr.start) {
	        			res.add(curr);
	        		} else {
	        			prev.end = Math.max(curr.end, prev.end);
	        		}
	        }
	        return res;
	    }
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
