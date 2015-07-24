package org.ms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MagicBox {
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(
				System.in));
		String[] numsString = read.readLine().split(" ");
		String sequence = read.readLine();
		int[] nums = new int[3];
		for(int i = 0; i < 3; i++) {
			nums[i] = Integer.parseInt(numsString[i]);
		}
		Arrays.sort(nums);
		if(nums[0] + nums[1] != nums[2]) {
			System.out.println(sequence.length());
			return;
		}
		int cR = 0, cY = 0, cB = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < sequence.length(); i++) {
			char curt = sequence.charAt(i);
			if (curt == 'R') {
				cR++;
			} else if (curt == 'B') {
				cB++;
			} else if (curt == 'Y') {
				cY++;
			}
			List<Integer> tmp = Arrays.asList(cR, cY, cB);
			Collections.sort(tmp);
			if(tmp.get(1) - tmp.get(0) == nums[0] && tmp.get(2) - tmp.get(1) == nums[1]) {
				max = Math.max(max, cR + cY + cB);
				cR = cY = cB = 0;
			}
		}
		max = Math.max(max, cR + cY + cB);
		System.out.println(max);
	}
}
