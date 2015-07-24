package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidNumber {
    public boolean isNumber(String s) {
    		if(s.endsWith("f") || s.endsWith("F") ||
    				s.endsWith("d") || s.endsWith("D") ||
    				s.endsWith("l") || s.endsWith("L")) {
    			return false;
    		}
    		try {
    			Double number = Double.parseDouble(s);
    			System.out.println(number);
    		} catch(Exception e) {
    			return false;
    		}
    		return true;
    }
    
    public boolean isNumber2(String s) {
    		s = s.trim();
    		boolean numSeen = false, dotSeen = false, eSeen = false, withNumAfterE = true;
    		for(int i = 0; i < s.length(); i++) {
    			char curt = s.charAt(i);
    			if(curt >= '0' && curt <= '9') {
    				numSeen = true;
				withNumAfterE = true;
    			} else if(curt == '-' || curt == '+') {
    				if(i > 0 && (s.charAt(i - 1) != 'E' && s.charAt(i - 1) != 'e')) {
    					return false;
    				}
    			} else if(curt == '.') {
    				if(eSeen || dotSeen) {
    					return false;
    				}
    				dotSeen = true;
    			} else if(curt == 'e' || curt == 'E') {
    				if(!numSeen || eSeen) {
    					return false;
    				}
    				eSeen = true;
    				withNumAfterE = false;
    			} else {
    				return false;
    			}
    		}
    		return numSeen && withNumAfterE;
    }
    /**
     * using regular expression
     */
    public boolean isNumber3(String s) {
    		return s.matches("[-+]?/d(./d)?(e[-+]?/d)?");
    }
	@Test
	public void test() {
		assertEquals(false, isNumber3("959440.94f"));
	}
	
	@Test
	public void test1() {
		assertEquals(true, isNumber3("-1."));
	}

	@Test
	public void test2() {
		assertEquals(false, isNumber3("e"));
	}
	
	@Test
	public void case1() {
		assertEquals(true, isNumber3("3"));
	}
	
	@Test
	public void reg() {
		assertEquals(true, "word".matches("\\w*"));
	}
}
