package leetcode;

import org.junit.Test;

public class RectangleArea {
	public class Solution {
	    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
	        return area(A, B, C, D) + area(E, F, G, H) - area(E, B, C, H);
	    }
	    
	    private int area(int a, int b, int c, int d) {
	        int width = c - a, height = d - b;
	        return width > 0 && height > 0 ? width * height : 0;
	    }
	}
	
	@Test
	public void case1() {
		System.out.println(new Solution().computeArea(0, 0, 0, 0, -1, -1, 1, 1));
	}
}
