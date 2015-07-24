package leetcode;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.util.*;

public class Subsets {

	public List<List<Integer>> subsets2(int[] S) {
		List<List<Integer>> res = new LinkedList<>();
		res.add(new ArrayList<Integer>());
		Arrays.sort(S);
		for (Integer num : S) {
			int size = res.size();
			for (int i = 0; i < size; i++) {
				List<Integer> subSet = new ArrayList<>(res.get(i));
				subSet.add(num);
				res.add(subSet);
			}
		}
		return res;
	}

	@Test
	public void test() {
		long num = 62;
		ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
		buffer.putLong(num);
		BitSet bitSet = BitSet.valueOf(buffer.array());
		// for(int i = 0; i < 9; i++) {
		// System.out.println(bitSet.get(Long.SIZE - 1 - i));
		// }
		// System.out.println("end for lower");
		// for(int i = 0; i < 9; i++) {
		// System.out.println(bitSet.get(i));
		// }
		for (int i = 0; i < bitSet.size(); i++) {
			System.out.println("index " + i + ":" + bitSet.get(i));
		}
	}

}
