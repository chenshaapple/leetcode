package org.leetcode.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;


class Util {
	static class TestCase{
		public int[] numbers;
		public int target;
		
		public void printCase() {
			for(int number : numbers) {
				System.out.print(number + " ");
			}
			System.out.println(", target : " + target);
		}
	}
	static class OneSolution {
		int index[];
	}
	public static int[] twoSum(int[] numbers, int target) {
		//get the latent solution
		int min = Integer.MAX_VALUE;
		for(int number : numbers) {
			if(number < min) {
				min = number;
			}
		}
		
		if(min <= 0) {
			int offset = min * -1 + 1;
			for(int i = 0; i < numbers.length; i++) {
				numbers[i] += offset;
			}
			target += (offset * 2);
		}

		List<OneSolution> solutions = new ArrayList<OneSolution>();
		//keep index stay the consistent
		solutions.add(new OneSolution());
		int stub = target/2;
		for(int i = 1; i <= stub; i++) {
			OneSolution solution = new OneSolution();
			solution.index = new int[2];
			solutions.add(solution);
		}
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] >= target) {
				continue;
			}
			int current = numbers[i];
			int solutionIndex = current <= stub ? current : target - current;
			if(current < stub){
				solutions.get(solutionIndex).index[0] = i + 1;
			} else if(current == stub) {
				if(solutions.get(solutionIndex).index[0] == 0) {
					solutions.get(solutionIndex).index[0] = i + 1;
				} else {
					solutions.get(solutionIndex).index[1] = i + 1;
				}
			} else {
				solutions.get(solutionIndex).index[1] = i + 1;
			}
			
		}
		for(int i = 1; i < solutions.size(); i++) {
			if(solutions.get(i).index[0] != 0 && solutions.get(i).index[1] != 0) {
				if(solutions.get(i).index[0] > solutions.get(i).index[1]) {
					int index = solutions.get(i).index[0];
					solutions.get(i).index[0] = solutions.get(i).index[1];
					solutions.get(i).index[1] = index;
				}
				return solutions.get(i).index;
			}
		}
		return new int[]{0,0};
	}
}


public class Main {
	
	public static void main(String[] args) {
		List<Util.TestCase> testCases = new ArrayList<>();
		Util.TestCase case1 = new Util.TestCase();
		case1.numbers = new int[]{0,4,3,0};
		case1.target = 0;
		testCases.add(case1);
		
		for(Util.TestCase testCase : testCases) {
			testCase.printCase();
			int[] result = Util.twoSum(testCase.numbers, testCase.target);
			for(int number : result) {
				System.out.println("index is: " + number);
			}
		}
	}
}
