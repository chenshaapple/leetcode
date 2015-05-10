package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		String[] versionArray1 = version1.split("\\.");
		String[] versionArray2 = version2.split("\\.");
		int i = 0;
		while (i < versionArray1.length && i < versionArray2.length) {
			int tmp = Integer.valueOf(versionArray1[i]).compareTo(
					Integer.valueOf(versionArray2[i]));
			if(tmp != 0) {
				return tmp;
			}
			i++;
		}
		while(i < versionArray1.length) {
			if(Integer.valueOf(versionArray1[i++]) > 0) {
				return 1;
			}
		}
		while(i < versionArray2.length) {
			if(Integer.valueOf(versionArray2[i++]) > 0) {
				return -1;
			}
		}
		return 0;
	}

	@Test
	public void test() {
		System.out.println(Integer.valueOf("0_111_123"));
	}

}
