package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CourseScheduleII {
	public class Solution {
		private List<Set<Integer>> prev;
		private List<Set<Integer>> post;
		private Deque<Integer> deque = new LinkedList<>();
		private int size;
	    public int[] findOrder(int numCourses, int[][] prerequisites) {
			size = numCourses;
			int[] res = new int[size];
			prev = new ArrayList<>(size);
			post = new ArrayList<>(size);
			for (int i = 0; i < size; i++) {
				prev.add(new HashSet<>());
				post.add(new HashSet<>());
			}
			for (int[] pair : prerequisites) {
				prev.get(pair[0]).add(pair[1]);
				post.get(pair[1]).add(pair[0]);
			}
			for (int i = 0; i < size; i++)
				if (prev.get(i).isEmpty())
					deque.addLast(i);
			int finished = 0;
			while (!deque.isEmpty()) {
				int take = deque.pollFirst();
				post.get(take).forEach(i -> {
					prev.get(i).remove(take);
					if (prev.get(i).isEmpty())
						deque.addLast(i);
				});
				res[finished++] = take;
			}
			return finished == size ? res : new int[0];
	    }
	}
}
