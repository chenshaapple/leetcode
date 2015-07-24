package org.ms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProfessorQ {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		int T = Integer.parseInt(reader.readLine());
		StringBuilder resBuilder = new StringBuilder();
		for (int i = 0; i < T; i++) {
			String[] line = reader.readLine().split(" ");
			int moduleCount = Integer.parseInt(line[0]), instCount = Integer.parseInt(line[1]);
			Map<Integer, List<Integer>> modules = new HashMap<>();
			Map<Integer, Integer> res = new HashMap<>();
			List<Integer> moduleInOrder = new ArrayList<>();
			Deque<Integer> deque = new LinkedList<>();
			for(String inst : reader.readLine().split(" ")) {
				deque.addLast(Integer.parseInt(inst));
			}
			for (int moduleIndex = 0; moduleIndex < moduleCount; moduleIndex++) {
				String[] moduleLine = reader.readLine().split(" ");
				int module = Integer.parseInt(moduleLine[0]);
				int signalCount = Integer.parseInt(moduleLine[1]);
				List<Integer> signalList = new ArrayList<Integer>();
				for(int signalIndex = 0; signalIndex < signalCount; signalIndex++) {
					signalList.add(Integer.parseInt(moduleLine[2 + signalIndex]));
				}
				modules.put(module, signalList);
				moduleInOrder.add(module);
			}
			while(!deque.isEmpty()) {
				int size = deque.size();
				for(int curt = 0; curt < size; curt++) {
					int inst = deque.pollFirst();
					if(modules.containsKey(inst)) {
						if(res.containsKey(inst)) {
							res.put(inst, res.get(inst) + 1);
						} else {
							res.put(inst, 1);
						}
						for(Integer next : modules.get(inst)) {
							deque.addLast(next);
						}
					}
				}
			}
			for(Integer module : moduleInOrder) {
				resBuilder.append(res.get(module) + " ");
			}
			resBuilder.append("\n");
		}
		System.out.println(resBuilder.toString());
	}
}
