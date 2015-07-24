package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

/*
 * ˼·��ֱ�Ӹ��ݶ������ͺã����Թ�ֱ���Ƶ�ĳһ��Ĺ�ʽʧ����
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> result = new LinkedList<>();
    	if(numRows <= 0) {
    		return result;
    	}
        
    	result.add(Arrays.asList(1));
        for(int size = 2; size <= numRows; size++) {
        	List<Integer> thisLevel = new LinkedList<>();
        	List<Integer> upperLevel = result.get(size - 2);
        	for(int i = 0; i < size; i++) {
        		int left = i - 1 >= 0 ? upperLevel.get(i  - 1) : 0;
        		int top = i < size - 1 ? upperLevel.get(i) : 0;
        		thisLevel.add(left + top);
        	}
        	result.add(thisLevel);
        }
        return result;
    }
	@Test
	public void test() {
		List<List<Integer>> result = generate(5);
		assertEquals(5, result.size());
	}

}
