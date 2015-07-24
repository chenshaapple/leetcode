package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;
/*
 * ˼·�� ��������һ��ģ��ռ临�Ӷ�ΪO(n),ʱ�临�Ӷ�Ϊ��Iһ��
 */
public class PascalsTriangleII {
	private List<List<Integer>> memo = new LinkedList<>();
	{
		memo.add(Arrays.asList(1));
	}
    public List<Integer> getRow(int rowIndex) {
    	List<Integer> result = new LinkedList<>(Arrays.asList(1));
    	List<Integer> upperLevel = new LinkedList<>();
    	List<Integer> tmp = null;
        for(int size = 2; size <= rowIndex + 1; size++) {
        	tmp = upperLevel;
        	upperLevel = result;
        	result = tmp;
        	result.clear();
        	for(int i = 0; i < size; i++) {
        		int left = i - 1 >= 0 ? upperLevel.get(i  - 1) : 0;
        		int top = i < size - 1 ? upperLevel.get(i) : 0;
        		result.add(left + top);
        	}
        }
        return result;
    }
    public List<Integer> getRowUsingMemo(int rowIndex) {
    	if(rowIndex < memo.size()) {
    		return memo.get(rowIndex);
    	}
    	List<Integer> result = new LinkedList<>(memo.get(memo.size() - 1));
    	List<Integer> upperLevel = new LinkedList<>();
    	List<Integer> tmp = null;
        for(int size = result.size() + 1; size <= rowIndex + 1; size++) {
        	tmp = upperLevel;
        	upperLevel = result;
        	result = tmp;
        	result.clear();
        	for(int i = 0; i < size; i++) {
        		int left = i - 1 >= 0 ? upperLevel.get(i  - 1) : 0;
        		int top = i < size - 1 ? upperLevel.get(i) : 0;
        		result.add(left + top);
        	}
        	memo.add(result);
        }
        return result;
    }
    
	@Test
	public void test() {
		List<Integer> result = getRowUsingMemo(3);
		for(Integer num : result) {
			System.out.print(num + "\t");
		}
	}

}
