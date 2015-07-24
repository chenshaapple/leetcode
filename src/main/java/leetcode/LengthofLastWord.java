package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
		if(s == null) {
			return 0;
		}
		String[] words = s.split(" ");
		if (words.length > 0) {
			return words[words.length - 1].length();
		}
		return 0;
	}

	@Test
	public void test() {
		assertEquals(5, lengthOfLastWord("Hello World"));
	}

	@Test
	public void test1() {
		assertEquals(0, lengthOfLastWord(null));
	}
	
}
