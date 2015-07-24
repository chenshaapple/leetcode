package com.geeksforgeeks;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindTheLargestPair {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			int size = scanner.nextInt();
			if(size < 2)
				break;
			List<Integer> nums = new ArrayList<>(size);
			for(int i = 0; i < size; i++)
				nums.add(scanner.nextInt());
			PriorityQueue<Integer> queue = new PriorityQueue<>(2);
			nums.forEach(num -> {
				if(queue.size() < 2)
					queue.add(num);
				else if(num > queue.peek()) {
					queue.poll();
					queue.add(num);
				}
			});
			System.out.println(queue.stream().reduce(Integer::sum).get());
		}
		scanner.close();
	}
}
