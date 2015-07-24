package leetcode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ImplementTrie {
	class TrieNode {
	    // Initialize your data structure here.
		boolean hasWord;
		TrieNode[] children;
	    public TrieNode() {
	        children = new TrieNode[26];
	    }
	}

	public class Trie {
	    private TrieNode root;

	    public Trie() {
	        root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
	    		TrieNode level = root;
	    		for(char c : word.toCharArray()) {
	    			if(level.children[c - 'a'] == null) {
	    				level.children[c - 'a'] = new TrieNode();
	    			}
	    			level = level.children[c - 'a'];
	    		}
	    		level.hasWord = true;
	    }

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	    		TrieNode level = root;
	        for(char c : word.toCharArray()) {
	        		if(level.children[c - 'a'] == null)
	        			return false;
	        		level = level.children[c - 'a'];
	        }
	        return level.hasWord;
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
    			TrieNode level = root;
	        for(char c : prefix.toCharArray()) {
	        		if(level.children[c - 'a'] == null)
	        			return false;
	        		level = level.children[c - 'a'];
	        }
		    return true;
	    }
	}
	Trie trie;
	@Before
	public void setUp() {
		trie = new Trie();
	}
	
	@Test
	public void search() {
		trie.insert("a");
		assertTrue(trie.search("a"));
		assertTrue(trie.startsWith("a"));
	}
	
	@Test
	public void search1() {
		trie.insert("abc");
		assertFalse(trie.search("ab"));
		assertTrue(trie.startsWith("ab"));
	}
	
	@Test
	public void search2() {
		trie.insert("abc");
		assertFalse(trie.search("ab"));
		trie.insert("ab");
		assertTrue(trie.search("ab"));
		assertTrue(trie.startsWith("ab"));
	}
	
	@Test
	public void startsWith() {
		trie.insert("ab");
		assertFalse(trie.search("a"));
		assertTrue(trie.startsWith("a"));
	}
}
