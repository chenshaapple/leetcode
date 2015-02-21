package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new LinkedList<>();
        intervals.add(newInterval);
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
		Collections.sort(intervals, new Cmp());
		result.add(intervals.get(0));
		for(int i = 1; i < intervals.size(); i++) {
			Interval previous = result.get(result.size() - 1);
			Interval current = intervals.get(i);
			//no overlap
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
