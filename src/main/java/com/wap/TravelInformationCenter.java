package com.wap;

import java.util.BitSet;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TravelInformationCenter {
	
	public static void main(String[] args) {
		class Node {
			List<Integer> next = new LinkedList<>();
		}
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt(), m = scanner.nextInt();
		Node[] nodes = new Node[n + 1];
		Set<Integer> set = new HashSet<>();
		set.add(1);
		for(int i = 1; i <= n; i++)
			nodes[i] = new Node();
		for(int i = 0; i < n - 1; i++) {
			int from = scanner.nextInt(), to = scanner.nextInt();
			nodes[from].next.add(to);
			nodes[to].next.add(from);
		}
		for(int query = 0; query < m; query++) {
			int type = scanner.nextInt(), target = scanner.nextInt();
			if(type == 1) {
				set.add(target);
				continue;
			}
			if(set.contains(target))
				System.out.println(0);
			else {
				int res = Integer.MAX_VALUE;
				for(Integer inSetNo : set) {
					Deque<Integer> deque = new LinkedList<>();
					deque.addLast(inSetNo);
					BitSet visited = new BitSet();
					int curr = 0;
					int currRes = 0;
					while(!deque.isEmpty()) {
						int size = deque.size();
						for(int i = 0; i < size; i++) {
							int nextNo = deque.pollFirst();
							if(visited.get(nextNo)) continue;
							visited.set(nextNo);
							if(nextNo == target) {
								currRes = curr;
								res = Math.min(res, currRes);
								break;
							}
							for(Integer nextNext : nodes[nextNo].next)
								deque.addLast(nextNext);
						}
						if(currRes != 0) break;
						curr++;
					}
				}
				System.out.println(res);
			}
		}
		scanner.close();
	}
}
