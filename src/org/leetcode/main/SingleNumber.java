package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class SingleNumber {
	public int singleNumber(int[] A) {
		int res = A[0];
		for (int i = 1; i < A.length; i++) {
			res ^= A[i];
		}
		return res;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
