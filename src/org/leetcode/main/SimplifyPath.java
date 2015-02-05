package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SimplifyPath {
	public String simplifyPath(String path) {
		String result = "";
		Stack<String> directoryStack = new Stack<>();
		String[] directorys = path.split("//*");
		for (int i = 0; i < directorys.length; i++) {
			if(directorys[i].equals("")) {
				continue;
			}
			if (directorys[i].equals("..")) {
				if (!directoryStack.isEmpty()) {
					directoryStack.pop();
				}
			} else if (!directorys[i].equals(".")) {
				directoryStack.push(directorys[i]);
			}
		}
		for (String dir : directoryStack) {
			result += "/" + dir;
		}
		return result.equals("") ? "/" : result;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals("/home", simplifyPath("/home/"));
	}

	@Test
	public void test2() {
		assertEquals("/c", simplifyPath("/a/./b/../../c/"));
	}
	
	@Test
	public void test3() {
		assertEquals("/abc/...", simplifyPath("/abc/..."));
	}
}
