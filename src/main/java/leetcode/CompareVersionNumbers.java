package leetcode;

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
	
	public class Solution {
	    public int compareVersion(String version1, String version2) {
	        String[] vs1 = version1.split("\\."), vs2 = version2.split("\\.");
	        
	        String main1 = vs1[0], minor1 = vs1.length > 1 ? vs1[1] : "0";
	        String main2 = vs2[0], minor2 = vs2.length > 1 ? vs2[1] : "0";
	        int minorSize = Math.max(minor1.length(), minor2.length());
	        return Double.compare(Integer.valueOf(main1) * Math.pow(10, minorSize) + Integer.valueOf(minor1),
	            Integer.valueOf(main2) * Math.pow(10, minorSize) + Integer.valueOf(minor2));
	    }
	}

	Solution sln = new Solution();
	@Test
	public void test() {
		System.out.println(sln.compareVersion("1.00000000000000000000001", "1.10"));
	}

}
