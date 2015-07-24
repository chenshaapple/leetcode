package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindPeakElement {
	//���ֽⷨ�Ƚϴ���n��ͦ����
    public int findPeakElement(int[] num) {
        for(int i = 1; i < num.length; i++) {
            if(num[i - 1] > num[i]) {
                return i - 1;
            }
        }
        return num.length - 1;
    }
    
    public int findPeakElementFast(int[] num) {
    	int begin = 0, end = num.length - 1;
    	while(begin < end) {
    		int mid = (begin + end) / 2;
    		if(num[mid] < num[mid + 1]) {
    			begin = mid + 1;
    		} else {
    			end = mid;
    		}
    	}
    	return begin;
    }
    
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
