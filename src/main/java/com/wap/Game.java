package com.wap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
	public static enum Test {
		A {
			@Override
			public int convert() {
				// TODO Auto-generated method stub
				return 0;
			}
		},G {
			@Override
			public int convert() {
				// TODO Auto-generated method stub
				return 0;
			}
		},C {
			@Override
			public int convert() {
				// TODO Auto-generated method stub
				return 0;
			}
		},T {
			@Override
			public int convert() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		public abstract int convert();
	}
	public static void main(String[] args) {
		Test.valueOf("A");
		Map<CharSequence, Integer> map = new HashMap<>();
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[][] grid = new int[n][m + 1];
		for(int row = 0; row < n; row++) {
			for(int col = 1; col <= m; col++)
				grid[row][col] = scanner.nextInt();
		}
		int[] dir = {1,-1};
		for(int col = 1; col <= m; col++) {
			int[] curr = new int[n];
			Arrays.fill(curr, -1);
			for(int row = 0; row < n; row++) {
				if(grid[row][col - 1] == -1 || grid[row][col] == -1)continue;
				for(int d : dir) {
					int pos = row;
					int[] tmp = new int[n];
					Arrays.fill(tmp, -1);
					tmp[row] = grid[row][col - 1] + grid[row][col];
					for(int i = 0; i < n - 1; i++) {
						if(tmp[pos] == -1) break;
						int prev = tmp[pos];
						pos += d;
						if(pos < 0 || pos == n) {
							prev = 0;
							if(pos < 0)
								pos = n - 1;
							else if(pos == n) 
								pos = 0;
						}
						if(grid[pos][col] == -1) continue;
						tmp[pos] = grid[pos][col] + prev;
					}
					for(int i = 0; i < n; i++)
						curr[i] = Math.max(curr[i], tmp[i]);
				}
			}
			for(int i = 0; i < n; i++)
				grid[i][col] = curr[i];
		}
		int res = - 1;
		for(int row = 0; row < n; row++)
			res = Math.max(res, grid[row][m]);
		System.out.println(res);
		scanner.close();
	}
}
