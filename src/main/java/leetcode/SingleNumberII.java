package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class SingleNumberII {
	// ����һ��ͨ�õķ���
	public int singleNumber(int[] A) {
		int times = 3;
		int[] digits = new int[32];
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < A.length; j++) {
				// digits[i] += (A[j] >> i) & 1;
				digits[i] += (A[j]) & 1;
				A[j] >>= 1;
			}
		}
		int res = 0;
		for (int i = 0; i < 32; i++) {

			res += (digits[i] % times) << i;
		}
		return res;
	}

	public int singleNumberFast(int[] A) {
		int one = 0, two = 0, three = 0;
		for (int num : A) {
			three = two & num;// �Ѿ����������Σ���������һ��
			two = two | one & num;// ������1���ֳ�����1�Σ��ڼ�����ǰ�Ѿ�������2�εģ�Ϊ�µĳ�����2�ε�
			one = one | num;// ������1��
			// ������3�ε������1��2��ȫ��Ĩȥ
			one = one & ~three;
			two = two & ~three;
		}
		return one;
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
