package leetcode;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class MaxPointsOnALine {
	public class Solution {
	    public int maxPoints(Point[] points) {
	        if(points.length < 2) return points.length;
	        int res = 1;
	        Map<Double, Integer> lines = new HashMap<>();
	        for(int i = 0; i < points.length - 1; i++) {
	            lines.clear();
	            int dup = 0;
	            lines.put((double)Integer.MIN_VALUE, 1);
	            Point p1 = points[i];
	            for(int j = i + 1; j < points.length; j++) {
	                Point p2 = points[j];
	                if(p1.x == p2.x && p1.y == p2.y) {
	                    dup++;
	                    continue;
	                }
	                double a = p1.x == p2.x ? Double.MAX_VALUE : 0.0 + (double)(p1.y - p2.y)/(double)(p1.x - p2.x);
	                lines.computeIfPresent(a, (k,v) -> v + 1);
	                lines.computeIfAbsent(a, k -> 2);
	            }
	            for(int count : lines.values())
	                res = Math.max(res, count + dup);
	        }
	        return res;
	    }
	}
	
	private Solution sln = new Solution();
	@Test
	public void case1() {
		assertEquals(1, sln.maxPoints(new Point[]{new Point(0,0)}));
	}
	
	@Test
	public void case2() {
		assertEquals(3, sln.maxPoints(new Point[]{new Point(0,0), new Point(-1,-1), new Point(2,2)}));
	}
	
	@Test
	public void case3() {
		assertEquals(3, sln.maxPoints(new Point[]{new Point(2,3), new Point(3,3), new Point(-5,3)}));
	}
}
