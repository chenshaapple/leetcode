package leetcode;

import static org.junit.Assert.*;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

public class AddandSearchWord {
	public class WordDictionary {
		class Tier {
			boolean hasWord;
			Tier[] children;
			public Tier() {
				children = new Tier[26];
			}
		}
		
		private Tier root;
		
		public WordDictionary() {
			root = new Tier();
		}
	    // Adds a word into the data structure.
	    public void addWord(String word) {
	    		Tier level = root;
	        for(char c : word.toCharArray()) {
	        		if(level.children[c - 'a'] == null)
	        			level.children[c - 'a'] = new Tier();
	        		level = level.children[c - 'a'];
	        }
	        level.hasWord = true;
	    }

	    // Returns if the word is in the data structure. A word could
	    // contain the dot character '.' to represent any one letter.
	    public boolean search(String word) {
	    		return search(word, root);
	    }
	    
	    private boolean search(String word, Tier level) {
	    		if(level == null || word == null)
	    			return false;
	    		if(word.equals(""))
	    			return level.hasWord;
	    		char curr = word.charAt(0);
	    		if(curr == '.') {
	    			for(Tier child : level.children)
	    				if(child != null && search(word.substring(1), child))
	    					return true;
	    			return false;
	    		} else
	    			return search(word.substring(1), level.children[curr - 'a']);
	    }
	}

	// Your WordDictionary object will be instantiated and called as such:
	// WordDictionary wordDictionary = new WordDictionary();
	// wordDictionary.addWord("word");
	// wordDictionary.search("pattern");
	
	@Test
	public void case1() {
		WordDictionary dict = new WordDictionary();
		dict.addWord("a");
		assertTrue(dict.search("a"));
		assertTrue(dict.search("."));
		assertFalse(dict.search("b"));
	}
	
	@Test
	public void case2() {
		WordDictionary dict = new WordDictionary();
		dict.addWord("at");
		dict.addWord("and");
		dict.addWord("an");
		dict.addWord("add");
		dict.search(".at");
		dict.addWord("bat");
		dict.search(".at");
		dict.search("an.");
		dict.search("a.d.");
		dict.search("b.");
	}
}
