package leetcode;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import leetcode.LRUCache.CacheNode;

public class LRUCacheImplByHashMap {
	class CacheNode {
		int key;
		int value;
		CacheNode prev;
		CacheNode next;

		public CacheNode(int key, int value) {
			this.key = key;
			this.value = value;
		}
		public CacheNode() {
		}
	}
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
