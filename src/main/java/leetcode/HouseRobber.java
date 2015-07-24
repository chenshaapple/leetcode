package leetcode;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

public class HouseRobber {
	public int rob(int[] num) {
		if (num.length == 0) {
			return 0;
		}
		int[][] opt = new int[num.length][2];
		opt[0][0] = 0;
		opt[0][1] = num[0];
		for (int i = 1; i < num.length; i++) {
			opt[i][0] = Math.max(opt[i - 1][0], opt[i - 1][1]);
			opt[i][1] = Math.max(opt[i - 1][0] + num[i], opt[i - 1][1]);
		}
		return Math.max(opt[num.length - 1][0], opt[num.length - 1][1]);
	}

	@Test
	public void test() {
		assertEquals(2, rob(new int[] { 1, 2 }));
		Optional<Integer> num = Optional.of(3);
		num.ifPresent(s ->{System.out.println(s);});
		if(num.isPresent()) {
			int tmp = num.get();
			System.out.println(tmp);
		}
	}

}
