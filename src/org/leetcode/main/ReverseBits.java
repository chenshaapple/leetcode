package org.leetcode.main;

import static org.junit.Assert.*;

import java.nio.ByteBuffer;
import java.util.BitSet;

import org.junit.Test;

public class ReverseBits {
	public int reverseBits(int n) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(Integer.BYTES);
		byteBuffer.putInt(n);
		BitSet bits = new BitSet(Integer.SIZE);
		bits.or(BitSet.valueOf(byteBuffer.array()));
		int halfSize = bits.length() / 2;
		printBits(bits);
		for (int i = 0; i < halfSize; i++) {
			boolean tmp = bits.get(i);
			bits.set(i, bits.get(Integer.SIZE - 1 - i));
			bits.set(Integer.SIZE - 1 - i, tmp);
		}
		printBits(bits);
		byte[] src = bits.toByteArray();
		byte[] result = new byte[Integer.BYTES];
		
		System.arraycopy(src, 0, result, 0, src.length);
//		System.arraycopy(src, 0, result, 4 - src.length, src.length);
		return result.length == 0 ? 0 : ByteBuffer.wrap(result).asIntBuffer()
				.get();
	}
	
	public int reveserBitsUsingString(int n) {
		StringBuilder result = new StringBuilder();
		String binary = Integer.toBinaryString(n);
		for(int i = 0; i < 32 - binary.length(); i++) {
			result.append('0');
		}
		result.append(binary);
		return Integer.parseUnsignedInt(result.reverse().toString(), 2);
	}

	void printBits(BitSet bits) {
		for (int i = 0; i < 32; i++) {
			System.out.print(bits.get(i) ? 1 : 0);
		}
		System.out.println();
	}

	@Test
	public void test() {
	
		assertEquals(Integer.MIN_VALUE, reveserBitsUsingString(1));
	}

	@Test
	public void test1() {
		assertEquals(964176192, reveserBitsUsingString(43261596));
	}
	
	@Test
	public void test2() {
		assertEquals(8388608, reveserBitsUsingString(256));
	}
}
