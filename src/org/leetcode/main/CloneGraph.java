package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();
		if (node == null) {
			return null;
		}
		Deque<UndirectedGraphNode> deque = new LinkedList<>();
		deque.addLast(node);
		visited.put(node, new UndirectedGraphNode(node.label));
		while (!deque.isEmpty()) {
			UndirectedGraphNode curt = deque.pollFirst();
			for(UndirectedGraphNode neighbor : curt.neighbors) {
				if(!visited.containsKey(neighbor)) {
					UndirectedGraphNode clone = new UndirectedGraphNode(neighbor.label);
					visited.put(neighbor, clone);
					deque.addLast(neighbor);
				}
				visited.get(curt).neighbors.add(visited.get(neighbor));
			}
		}
		return visited.get(node);
	}

	@Test
	public void test() {
		UndirectedGraphNode node = new UndirectedGraphNode(0);
		node.neighbors.add(node);
		node.neighbors.add(node);

		UndirectedGraphNode clone = cloneGraph(node);

		assertEquals(2, clone.neighbors.size());
	}

}
