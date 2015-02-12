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

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
