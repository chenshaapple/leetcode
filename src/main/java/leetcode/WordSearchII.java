package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import leetcode.ImplementTrie.Trie;

public class WordSearchII {
	public class Solution {
		class TrieNode {
			TrieNode[] children;
			boolean hasWord;
			String value;
			public TrieNode() {
				children = new TrieNode[26];
			}
		}
		private char[][] board;
		private boolean[][] visited;
		private int[][] dirs = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, };
		private TrieNode root;
		private List<String> res;
		private Set<String> set;

		public List<String> findWords(char[][] board, String[] words) {
			res = new ArrayList<>(words.length);
			set = new HashSet<>();
			this.board = board;
			root = new TrieNode();
			visited = new boolean[board.length][board[0].length];
			for (String word : words)
				insert(word);
			for (int row = 0; row < board.length; row++) {
				for (int col = 0; col < board[0].length; col++) {
					findWords(row, col, root);
				}
			}

			return res;
		}
		
		private void insert(String word) {
			TrieNode curr = root;
			for(char c : word.toCharArray()) {
				int index = c - 'a';
				if(curr.children[index] == null)
					curr.children[index] = new TrieNode();
				curr = curr.children[index];
			}
			curr.hasWord = true;
			curr.value = word;
		}

		private void findWords(int row, int col, TrieNode curr) {
			if(curr == null) return;
			if(curr.hasWord) {
				if(!set.contains(curr.value)){
					set.add(curr.value);
					res.add(curr.value);
				}
			}
			if(row >=0 && row < board.length
				&& col >=0 && col < board[0].length
				&& !visited[row][col]) {
				int index = board[row][col] - 'a';
				visited[row][col] = true;
				for(int[] dir : dirs) {
					findWords(row + dir[0], col + dir[1], curr.children[index]);
				}
				visited[row][col] = false;
			}
		}
	}

	private Solution sln = new Solution();

	@Test
	public void case1() {
		String[] words = new String[] { "acdb" };
		char[][] board = { { 'a', 'b' }, { 'c', 'd' }, };
		System.out.println(sln.findWords(board, words));
	}
	
	@Test
	public void case2() {
		String[] words = new String[] {"ab"};
		char[][] board = {{'a'}};
		System.out.println(sln.findWords(board, words));
	}
	
	@Test
	public void case3() {
		String[] words = new String[] {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};
		char[][] board = {"ab".toCharArray(),"cd".toCharArray()};
		System.out.println(sln.findWords(board, words));
	}
}
