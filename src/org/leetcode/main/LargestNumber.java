package org.leetcode.main;

import static org.junit.Assert.*;

import java.lang.instrument.ClassDefinition;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class LargestNumber {
	class Human {
		private int age;
		private String name;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
	}
	public String largestNumber(int[] num) {
		StringBuilder res = new StringBuilder();
		Integer[] array = new Integer[num.length];
		for(int i = 0; i < num.length; i++) {
			array[i] = Integer.valueOf(num[i]);
		}
		Arrays.sort(array, (i1, i2)-> {
			String str1 = String.valueOf(i1), str2 = String.valueOf(i2);
			return -(str1 + str2).compareTo(str2 + str1);
		});
		if(0 < array.length && array[0] == 0) {
		    return "0";
		}
		for (int i = 0; i < array.length; i++) {
			res.append(array[i]);
		}
		return res.toString();
	}

	@Test
	public void test() {
		char a = 255, b = 10;
		System.out.println(a + b);
		System.out.println(largestNumber(new int[] { 121, 12 }));
	}

	@Test
	public void testParseInt() {
		System.out.println(Integer.valueOf("00"));
	}

	@Test
	public void test2812_2281() {
		System.out.println(largestNumber(new int[] { 4704, 6306, 9385, 7536,
				3462, 4798, 5422, 5529, 8070, 6241, 9094, 7846, 663, 6221, 216,
				6758, 8353, 3650, 3836, 8183, 3516, 5909, 6744, 1548, 5712,
				2281, 3664, 7100, 6698, 7321, 4980, 8937, 3163, 5784, 3298,
				9890, 1090, 7605, 1380, 1147, 1495, 3699, 9448, 5208, 9456,
				3846, 3567, 6856, 2000, 3575, 7205, 2697, 5972, 7471, 1763,
				1143, 1417, 6038, 2313, 6554, 9026, 8107, 9827, 7982, 9685,
				3905, 8939, 1048, 282, 7423, 6327, 2970, 4453, 5460, 3399,
				9533, 914, 3932, 192, 3084, 6806, 273, 4283, 2060, 5682, 2,
				2362, 4812, 7032, 810, 2465, 6511, 213, 2362, 3021, 2745, 3636,
				6265, 1518, 8398 }));
	}

	@Test
	public void test2_2281() {
		assertEquals("22812", largestNumber(new int[] { 2, 2281 }));
	}
}
