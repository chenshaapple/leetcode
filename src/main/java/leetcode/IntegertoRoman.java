package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * �����λ�����λһλһλ����
 */
public class IntegertoRoman {
    public String intToRoman(int num) {
        String[][] roman = {
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            {"", "M", "MM", "MMM"}
        };
        
        String ret = "";
        int digit = 0;
        while (num != 0) {
            int remain = num % 10;
            ret = roman[digit][remain] + ret;
            digit++;
            num /= 10;
        }
        
        return ret;
    }
    public class Solution {
        private String[][] roman = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
            };
        public String intToRoman(int num) {
            StringBuilder res = new StringBuilder();
            int digit = 0;
            while(num > 0) {
            		int low = num % 10;
            		res.insert(0, roman[digit++][low]);
            		num /= 10;
            }
            return res.toString();
        }
    }
	@Test
	public void test() {
		assertEquals("MMXVI", intToRoman(2016));
	}

}
