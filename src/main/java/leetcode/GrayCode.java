package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

/*
 * ����� ������Leetcode�����⣬��ΪleetCodeֻ���ж�Ψһ��grayCode���У���grayCode�Ǵ��ڶ����
 */
public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<>();
		if(n < 0) {
			return result;
		}
		result.add(0);
		result.add(1);
		for(int digit = 2; digit <= n; digit++) {
			for(int i = result.size() - 1; i >= 0; i--) {
				result.add((1 << (digit - 1)) + result.get(i));
			}
		}
		return result;
	}

	//����˼·����֤������ȷ�ԣ�û�취��֤�ݹ������������֮��Ĺ�ϵ������Ŀǰ�����Ǵ����
	//���ǳ���������û����������ǻ��ݵ�
	private void grayCode(List<Integer> result, Deque<Boolean> digits, int n) {
		if (n == 0) {
			result.add(convert(digits));
			return;
		}
		if(digits.isEmpty()) {
			digits.add(false);
			grayCode(result, digits, n - 1);
			digits.pollLast();
			digits.add(true);
			grayCode(result, digits, n - 1);
			digits.pollLast();
			return;
		}
		if(!digits.peekLast()) {
			digits.add(false);
			grayCode(result, digits, n - 1);
			digits.pollLast();
			digits.add(true);
			grayCode(result, digits, n - 1);
			digits.pollLast();
		} else {
			digits.add(true);
			grayCode(result, digits, n - 1);
			digits.pollLast();
			digits.add(false);
			grayCode(result, digits, n - 1);
			digits.pollLast();
		}
	}

	private int convert(Deque<Boolean> digits) {
		int tmp = 0;
		for(Boolean digit : digits) {
			tmp = (tmp << 1) + (digit ? 1 : 0);
		}
		return tmp;
	}

	@Test
	public void test() {
		List<Integer> result = grayCode(3);
		assertEquals(8, result.size());
	}

//	@Test
	public void testConvertor() {
		Deque<Boolean> digits = new LinkedList<>();
		digits.push(false);
		digits.push(false);
		digits.push(true);
		assertEquals(4, convert(digits));
	}
}
