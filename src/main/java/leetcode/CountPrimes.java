package leetcode;

import java.util.BitSet;

public class CountPrimes {
	public class Solution {
		public int countPrimes(int n) {
			int res = 0;
			BitSet bitSet = new BitSet(n);
			for (int base = 2; base < n; base++) {
				if (!bitSet.get(base)) {
					res++;
					for (int multiple = 2 * base; multiple < n; multiple = multiple + base)
						bitSet.set(multiple);
				}
			}
			return res;
		}
	}
}
