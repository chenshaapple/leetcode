package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.util.*;
public class Subsets {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new ArrayList<Integer>());
        Arrays.sort(S);
        for(int i = 0; i < S.length; i++){
            int size = result.size();
            for(int j = 0; j < size; j++){
                List<Integer> subSet = new LinkedList<>();
                subSet.addAll(result.get(j));
                subSet.add(S[i]);
                result.add(subSet);
            }
        }
        return result; 
    }
	@Test
	public void test() {
		long num = 62;
		ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
		buffer.putLong(num);
		BitSet bitSet = BitSet.valueOf(buffer.array());
//		for(int i = 0; i < 9; i++) {
//			System.out.println(bitSet.get(Long.SIZE - 1 - i));
//		}
//		System.out.println("end for lower");
//		for(int i = 0; i < 9; i++) {
//			System.out.println(bitSet.get(i));
//		}
		for(int i = 0; i < bitSet.size(); i++) {
			System.out.println("index " + i + ":" + bitSet.get(i));
		}
	}

}
