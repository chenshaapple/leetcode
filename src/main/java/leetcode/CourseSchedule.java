package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class CourseSchedule {
	public class Solution {
		private int[] prev;
		private List<Set<Integer>> post;
		private Deque<Integer> deque = new LinkedList<>();
		private int size;

		public boolean canFinish(int numCourses, int[][] prerequisites) {
			size = numCourses;
			prev = new int[size];
			post = new ArrayList<>(size);
			for (int i = 0; i < size; i++) {
				post.add(new HashSet<>());
			}
			for (int[] pair : prerequisites) {
				if (!post.get(pair[1]).contains(pair[0]))
					prev[pair[0]]++;
				post.get(pair[1]).add(pair[0]);
			}
			for (int i = 0; i < size; i++)
				if (prev[i] == 0)
					deque.addLast(i);
			int finished = 0;
			while (!deque.isEmpty()) {
				int take = deque.pollFirst();
				post.get(take).forEach(i -> {
					prev[i]--;
					if (prev[i] == 0)
						deque.addLast(i);
				});
				finished++;
			}
			return finished == size;
		}
	}

	
	public class Solution2 {
	    public boolean canFinish(int numCourses, int[][] prerequisites) {
	        List<Course> courses = new ArrayList<>(numCourses);
	        for(int i = 0; i < numCourses; i++)
	            courses.add(new Course(i));
	        for(int[] pair : prerequisites) {
	            courses.get(pair[0]).prev.add(courses.get(pair[1]));
	            courses.get(pair[1]).next.add(courses.get(pair[0]));
	        }
	        int taken = 0;
	        while(true) {
	            if(taken == numCourses) return true;
	            boolean canTake = false;
	            for(Course course : courses) {
	                if(course.prev.isEmpty() && !course.isTaken) {
	                    taken++;
	                    canTake = true;
	                    course.isTaken = true;
	                    for(Course next : course.next)
	                        next.prev.remove(course);
	                }
	            }
	            if(!canTake) return false;
	        }
	    }
	    
	    private class Course {
	        int id;
	        boolean isTaken;
	        Set<Course> prev;
	        Set<Course> next;
	        public Course(int id) {
	            this.id = id;
	            prev = new HashSet<>();
	            next = new HashSet<>();
	        }
	    }
	}
	
	private Solution2 sln = new Solution2();
	
	@Test
	public void case1() {
		int[][] prevs = {{0,1}};
		sln.canFinish(2, prevs);
	}
}
