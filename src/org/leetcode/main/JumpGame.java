package org.leetcode.main;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.Test;

public class JumpGame {
	/**
	 * 技止此耳
	 * @param A
	 * @return
	 */
	public boolean canJump2(int[] A) {
		int position = 0, step = A[0];
		while(position < A.length && step != position) {
			int nextStep = 0;
			for(int i = position + 1; i < A.length && i <= step; i++) {
				if(i + A[i] >= A.length - 1) {
					return true;
				}
				nextStep = Math.max(nextStep, i + A[i]);
			}
			position = step;
			step = nextStep;
		}
		return position >= A.length - 1;
	}
	
	/**
	 * DP: opt[i]表示i能否到达
	 * @param A
	 * @return
	 */
	public boolean canJump3(int[] A) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean[] opt = new boolean[A.length];
		opt[0] = true;
		for(int i = 1; i < A.length; i++) {
			for(int j = 1; j <= i; j++) {
				if(opt[i - j] && A[i - j] >= j) {
					opt[i] = true;
					break;
				}
			}
		}
		return opt[A.length - 1];
	}
	
	/**
	 * DP: opt[i]表示到达i时还剩多少步
	 */
	public boolean canJump4(int[] A) {
		int[] opt = new int[A.length];
		for(int i = 1; i < A.length; i++) {
			opt[i] = Math.max(A[i - 1], opt[i - 1]) - 1;
			if(opt[i] < 0) return false;
		}
		return opt[A.length - 1] >= 0;
	}
	
	/**
	 * 从最后一层开始向前走，看能否下到最底层。
	 */
	public boolean canJump5(int[] A) {
		int post = A.length - 1;
		for(int i = post - 1; i >= 0; i--) {
			if(i + A[i] >= post) {
				post = i;
			}
		}
		return post == 0;
	}
	/**
	 * 贪心。从第一层开始走，能否走到最高层
	 */
	public boolean canJump6(int[] A) {
		int post = 1;
		for(int i = 0; i < post && i < A.length; i++) {
			post = Math.max(post, i + A[i] + 1);
		}
		return post >= A.length;
	}
	@Test
	public void test() {
		assertEquals(true, canJump3(new int[] { 2, 5, 0, 0 }));
	}

	@Test
	public void test1() {
		assertEquals(true, canJump3(new int[] { 4, 1, 2, 0, 4, 0, 0, 0 }));
	}

	@Test
	public void test2() {
		assertEquals(false, canJump3(new int[] { 1, 0, 2 }));
	}

	@Test
	public void test3() {
		assertEquals(true, canJump3(new int[] { 1, 2, 0, 1 }));
	}

	@Test
	public void test4() {
		assertEquals(false, canJump3(new int[] { 1, 0, 2 }));
	}
	
	@Test
	public void test5() {
		assertEquals(true, canJump3(new int[]{1,1,2,2,0,1,1}));
	}
	
	@Test
	public void test6() {
		assertEquals(true, canJump3(new int[]{0}));
	}
}
