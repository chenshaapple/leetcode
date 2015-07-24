package com.wap;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GraphNode {
	int label;
	boolean festive;
	List<GraphNode> neighbors;

	GraphNode(int val) {
		label = val;
		festive = false;
		neighbors = new ArrayList<GraphNode>();
	}

	public void setFestive(boolean flag) {
		festive = flag;
	}

	public boolean getFestive() {
		return festive;
	}
}
public class Exam2ByJY {
	public static void main(String[] args) {
		InputStream in = null;
		in = Exam2ByJY.class.getResourceAsStream("Exam2Input.txt");
		System.setIn(in);
		Scanner scanner = new Scanner(System.in);
		int nodeNum = scanner.nextInt();
		int queryNum = scanner.nextInt();
		GraphNode[] graphNodes = new GraphNode[nodeNum + 1];
		for (int i = 1; i <= nodeNum; i++) {
			graphNodes[i] = new GraphNode(i);
		}
		for (int i = 1; i < nodeNum; i++) {
			int label1 = scanner.nextInt();
			int label2 = scanner.nextInt();
			graphNodes[label1].neighbors.add(graphNodes[label2]);
			graphNodes[label2].neighbors.add(graphNodes[label1]);
		}
		graphNodes[1].setFestive(true);
		for (int i = 0; i < queryNum; i++) {
			int type = scanner.nextInt();
			if (type == 1) {
				graphNodes[scanner.nextInt()].setFestive(true);
			} else if (type == 2) {
				boolean[] visited = new boolean[nodeNum + 1];
				System.out.println(getMinDistance(graphNodes,
						scanner.nextInt(), visited));
			} else {
				System.out.println("input error!");
			}
		}
		scanner.close();
	}

	private static int getMinDistance(GraphNode[] graphNodes, int label,
			boolean[] visited) {
		GraphNode node = graphNodes[label];
		if (node.getFestive() == true)
			return 0;
		int distance = 10 ^ 6;
		visited[label] = true;
		for (GraphNode nbor : node.neighbors) {
			if (!visited[nbor.label]) {
				distance = Math.min(distance,
						1 + getMinDistance(graphNodes, nbor.label, visited));
				visited[nbor.label] = true;
			}
			if (nbor.getFestive() == true)
				break; // pruning
		}
		return distance;
	}

}
