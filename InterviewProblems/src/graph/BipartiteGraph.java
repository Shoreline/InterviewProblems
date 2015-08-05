package graph;

import java.util.*;

public class BipartiteGraph {
    class Method {
	boolean isBipartiteGraph(List<UndirectedGraphNode> nodes) {
	    if (nodes == null || nodes.size() < 3) {
		return true;
	    }

	    // The value is one of the two colors
	    Map<UndirectedGraphNode, Boolean> colorMap = new HashMap<>();
	    Queue<UndirectedGraphNode> queue = new LinkedList<>();
	    Boolean color = true; // only two colors, so use Boolean

	    queue.add(nodes.get(0));
	    colorMap.put(nodes.get(0), color);
	    color = !color;

	    while (!queue.isEmpty()) {
		UndirectedGraphNode node = queue.poll();

		for (UndirectedGraphNode neighbor : node.neighbors) {
		    if (!colorMap.containsKey(neighbor)) {
			colorMap.put(neighbor, color);
			queue.add(neighbor);
		    } else if (colorMap.get(neighbor) != color) {
			return false;
		    }
		}

		color = !color;
	    }

	    return true;
	}
    }
}
