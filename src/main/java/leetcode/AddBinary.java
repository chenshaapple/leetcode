package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddBinary {
	public String addBinary(String a, String b) {
		StringBuilder result = new StringBuilder();
		int aIndex = a.length() - 1, bIndex = b.length() - 1;
		int isOverFlow = 0;
		while (aIndex >= 0 || bIndex >= 0 || isOverFlow == 1) {
			int tmp = isOverFlow;
			isOverFlow = 0;
			if(aIndex >= 0) {
				tmp += a.charAt(aIndex--) - '0';
			}
			if(bIndex >= 0) {
				tmp += b.charAt(bIndex--) - '0';
			}
			if(tmp >= 2) {
				isOverFlow = 1;
				tmp = tmp % 2;
			}
			result.append(tmp);
		}
		return result.reverse().toString();
	}

	@Test
	public void test() {
		System.out.println(addBinary("1", "11"));
	}

}
