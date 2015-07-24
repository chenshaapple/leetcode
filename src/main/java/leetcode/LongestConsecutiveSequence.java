package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
/*
 * ˼·�������Ҫ��O(n)��ʱ�临�Ӷȣ�������ȻӦ���������ܽ������ô���أ�Ͱ����
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
    	int result = 0, max = Integer.MIN_VALUE;
    	List<List<Integer>> bins = new ArrayList<>(20 - 1);
    	for(int i = 0; i < 20 - 1; i++) {
    		bins.add(new LinkedList<>());
    	}
    	for(int n : num) {
    		max = Math.max(max, Math.abs(n));
//    		bins.get(n % 10).add(n);
    	}
        int sortCount = findDigitCount(max);
        
        
        for(int i = 0; i < sortCount; i++) {
        	//insert into bin
        	int divide = (int)Math.pow(10, i);
        	for(int n : num) {
        		bins.get((n / divide) % 10 + 9).add(n);
        	}
        	//reorder into num[]
        	int newIndex = 0;
        	for(int binIndex = 0; binIndex < bins.size(); binIndex++) {
        		for(int offset = 0; offset < bins.get(binIndex).size(); offset++) {
        			num[newIndex++] = bins.get(binIndex).get(offset);
        		}
        	}
        	for(List<Integer> bin : bins) {
        		bin.clear();
        	}

        }
        int tmp = 1, candidate = num[0];
        for(int i = 1; i < num.length; i++) {
        	if(num[i] == (candidate)) {
        		continue;
        	}
        	if(num[i] == (++candidate)) {
        		tmp++;
        	} else {
        		result = Math.max(result, tmp);
        		tmp = 1;
        		candidate = num[i];
        	}
        }
        result = Math.max(result, tmp);
        return result;
    }
    
    private int findDigitCount(int num) {
    	int result = 0;
    	int divide = 1;
    	while((num / divide) != 0) {
    		divide *= 10;
    		result++;
    	}
    	return result;
    }
	@Test
	public void test() {
		assertEquals(3, longestConsecutive(new int[]{1,2,3}));
	}
	
	@Test
	public void test1() {
		assertEquals(3, longestConsecutive(new int[]{3,2,1, 10,11}));
	}

	@Test
	public void test2() {
		assertEquals(1, longestConsecutive(new int[]{73, 22, 93, 43, 55, 14, 28, 65, 39, 81}));
	}
	
	@Test
	public void testWithNenative() {
		assertEquals(2, longestConsecutive(new int[]{0,-1}));
	}
	
	@Test
	public void testWithHugeNumber() {
		assertEquals(3 , longestConsecutive(new int[]{2147483646,-2147483647,0,2,2147483644,-2147483645,2147483645}));
	}
	
	@Test
	public void testWithDuplicates() {
		assertEquals(3, longestConsecutive(new int[]{1,2,0,1}));
	}
}
