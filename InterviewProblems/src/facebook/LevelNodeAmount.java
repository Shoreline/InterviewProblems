package facebook;

import java.util.*;

/**
 * For a given tree (not necessarily a binary tree), get the node count by level
 */

public class LevelNodeAmount {
    class Node {
	int val;
	List<Node> children;
    }

    /*
     * Level order traversal. BST
     * 
     * queue.size() takes O(N) ? So avoid using it.
     */
    class Method {
	public List<Integer> count(Node root) {
	    if (root == null)
		return null;
	    Queue<Node> queue = new LinkedList<>();
	    List<Integer> res = new ArrayList<>();
	    queue.offer(root);
	    res.add(1);
	    int curLvl = 1;

	    while (!queue.isEmpty()) {
		int nextLvl = 0;

		for (int i = 0; i < curLvl; i++) {
		    Node n = queue.poll();
		    for (Node child : n.children) {
			nextLvl++;
			queue.offer(child);
		    }
		}

		res.add(nextLvl);
		curLvl = nextLvl;
	    }
	    return res;
	}
    }

    class Method2 {
	public List<Integer> count(Node root) {
	    if (root == null)
		return null;
	    Queue<Node> queue = new LinkedList<>();
	    List<Integer> res = new ArrayList<>();
	    queue.offer(root);
	    while (!queue.isEmpty()) {
		int curSize = queue.size(); // queue.size() takes O(N) ?
		res.add(curSize);

		for (int i = 0; i < curSize; i++) {
		    Node n = queue.poll();
		    for (Node child : n.children) {
			queue.offer(child);
		    }
		}
	    }
	    return res;
	}
    }

    /*
     * Keep going down to the k-th level, if there is a node, count++
     */
    class Method_Recursion {

    }
}
