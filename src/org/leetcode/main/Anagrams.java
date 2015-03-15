package org.leetcode.main;

/*
 * 思路：第一次尝试了遇到一个词就将其所有易位构词添加到map里,value是第一个词的索引，这样再遇到一个易位构词就将第一个也添加进去
 * 果不其然 超时了
 * 易位构词有专门的经典解法
 */
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

import javax.swing.text.DefaultEditorKit.CutAction;

public class Anagrams {
	
	public List<String> anagrams(String[] strs) {
		return null;
	}
	
	
	//its a AC solution
	public List<String> anagramsWithSort(String[] strs) {
		List<String> result = new LinkedList<String>();
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i < strs.length; i++) {
			String curt = strs[i];
			char[] curtArray = curt.toCharArray();
			Arrays.sort(curtArray);
			String sortedStr = Arrays.toString(curtArray);
			if (map.containsKey(sortedStr)) {
				int value = map.get(sortedStr);
				if(value != -1) {
					result.add(strs[map.get(sortedStr)]);
					map.put(sortedStr, -1);
				}
				result.add(curt);
			} else {
				map.put(sortedStr, i);
			}
		}
		return result;
	}
	
	public List<String> anagramsWithPermutaions(String[] strs) {
		List<String> result = new LinkedList<>();
		Set<String> set = new HashSet<>();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			String curt = strs[i];
			if (map.containsKey(curt)) {
				set.add(strs[map.get(curt)]);
				set.add(curt);
			} else {
				// add the anagrams of this word into map
				List<String> anagrams = new ArrayList<>();
				char[] curtArray = curt.toCharArray();
				Arrays.sort(curtArray);
				getAllAnagrams(anagrams, curtArray, new StringBuilder(),
						new boolean[curt.length()]);
				for (String anagram : anagrams) {
					map.put(anagram, i);
				}
			}
		}
		for (String word : set) {
			result.add(word);
		}
		return result;
	}

	private void getAllAnagrams(List<String> result, char[] word,
			StringBuilder anagram, boolean[] used) {
		if (anagram.length() == word.length) {
			result.add(anagram.toString());
			return;
		}
		for (int i = 0; i < word.length; i++) {
			if (i > 0 && !used[i - 1] && word[i] == word[i - 1]) {
				continue;
			}
			if (!used[i]) {
				used[i] = true;
				anagram.append(word[i]);
				getAllAnagrams(result, word, anagram, used);
				anagram.deleteCharAt(anagram.length() - 1);
				used[i] = false;
			}
		}
	}

	@Test
	public void testGetAnagrams() {
		List<String> anagrams = new ArrayList<>();
		char[] word = "array".toCharArray();
		Arrays.sort(word);
		getAllAnagrams(anagrams, word, new StringBuilder(),
				new boolean["array".length()]);
		for (String str : anagrams) {
			System.out.println(str);
		}
	}

	@Test
	public void test() {
		List<String> result = anagramsWithSort(new String[]{""});
		for (String str : result) {
			System.out.println(str);
		}
	}

}
