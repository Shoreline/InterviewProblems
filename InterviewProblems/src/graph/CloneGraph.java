package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Clone Graph
 * 
 * Clone an undirected graph. Each node in the graph contains a label and a list
 * of its neighbors.
 * 
 * 
 * OJ's undirected graph serialization: Nodes are labeled uniquely.
 * 
 * We use # as a separator for each node, and , as a separator for node label
 * and each neighbor of the node. As an example, consider the serialized graph
 * {0,1,2#1,2#2,2}.
 * 
 * The graph has a total of three nodes, and therefore contains three parts as
 * separated by #.
 * 
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2. Second node
 * is labeled as 1. Connect node 1 to node 2. Third node is labeled as 2.
 * Connect node 2 to node 2 (itself), thus forming a self-cycle. Visually, the
 * graph looks like the following:
 * 
 *     1
      / \
     /   \
    0 --- 2
         / \
         \_/
 *
 */

/*
 * 1) In Java, use LinkedList as queue
 * 2) LinkedList has addAll() method, handy for BFS
 */
public class CloneGraph {

    /*
     * BFS
     * 
     * Traverse graph twice
     */
    public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
	    if (node == null) {
		return null;
	    }

	    Map<UndirectedGraphNode, UndirectedGraphNode> nodeMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
	    // * LinkedList implements Queue
	    Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
	    queue.add(node);

	    while (!queue.isEmpty()) {
		UndirectedGraphNode head = queue.poll();

		if (!nodeMap.containsKey(head)) {
		    nodeMap.put(head, new UndirectedGraphNode(head.label));
		    // LinkedList has addAll() method
		    queue.addAll(head.neighbors);
		}
	    }

	    queue.add(node);
	    Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
	    while (!queue.isEmpty()) {
		UndirectedGraphNode head = queue.poll();
		UndirectedGraphNode headNew = nodeMap.get(head);

		if (!visited.contains(head)) {
		    for (UndirectedGraphNode neighbor : head.neighbors) {
			headNew.neighbors.add(nodeMap.get(neighbor));
		    }
		    queue.addAll(head.neighbors);
		    visited.add(head);
		}
	    }

	    return nodeMap.get(node);
	}
    }
}
