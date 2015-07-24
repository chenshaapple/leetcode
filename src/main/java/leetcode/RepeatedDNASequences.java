package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new LinkedList<>();
		//avoid same sequence
		Set<String> buf = new HashSet<>();
		Map<Integer, Boolean> map = new HashMap<>();
		for (int i = 0; i <= s.length() - 10; i++) {
			String sequence = s.substring(i, i + 10);
			int value = convert(sequence);
			if (!map.containsKey(value)) {
				map.put(value, true);
			} else {
				buf.add(sequence);
			}
		}
		for(String sequence : buf) {
			result.add(sequence);
		}
		return result;
	}

	//without this, memory will succeed
	private int convert(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			int value = 0;
			switch (s.charAt(i)) {
			case 'A':
				value = 0;
				break;
			case 'G':
				value = 1;
				break;
			case 'C':
				value = 2;
				break;
			case 'T':
				value = 3;
				break;
			}
			result = (result << 2) + value;
		}
		return result;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
