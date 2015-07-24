package com.geeksforgeeks;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class FindTheNearestsmallernumbersonleftsideinanarray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			int size = scanner.nextInt();
			if(size <= 0)
				break;
			List<Integer> nums = new ArrayList<>(size);
			List<Integer> res = new ArrayList<>(size);
			Deque<Integer> deque = new LinkedList<>();
			for(int i = 0; i < size; i++)
				nums.add(scanner.nextInt());
			nums.forEach(num -> {
				while(!deque.isEmpty() && deque.peek() > num)
					deque.pop();
				if(deque.isEmpty())
					res.add(null);
				else
					res.add(deque.peek());
				deque.push(num);
				return;
			});
			System.out.println(res);
		}
		scanner.close();
	}
}
