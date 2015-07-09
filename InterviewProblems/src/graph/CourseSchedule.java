package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Course Schedule
 * 
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * For example:
 * 
 * 2, [[1,0]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0. So it is possible.
 * 
 * 2, [[1,0],[0,1]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0, and to take course 0 you should also have
 * finished course 1. So it is impossible.
 * 
 * click to show more hints.
 * 
 * Hints: This problem is equivalent to finding if a cycle exists in a directed
 * graph. If a cycle exists, no topological ordering exists and therefore it
 * will be impossible to take all courses. There are several ways to represent a
 * graph. For example, the input prerequisites is a graph represented by a list
 * of edges. Is this graph representation appropriate? Topological Sort via DFS
 * - A great video tutorial (21 minutes) on Coursera explaining the basic
 * concepts of Topological Sort. Topological sort could also be done via BFS.
 * 
 *
 */

public class CourseSchedule {
  /*
   * Topological sort + BFS
   */
    public class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
	    if (numCourses < 2) {
		return true;
	    }

	    int[] inDegree = new int[numCourses];
	    Map<Integer, List<Integer>> outMap = new HashMap<Integer, List<Integer>>();

	    for (int i = 0; i < prerequisites.length; i++) {
		if (!outMap.containsKey(prerequisites[i][1])) {
		    outMap.put(prerequisites[i][1], new ArrayList<Integer>());
		}
		outMap.get(prerequisites[i][1]).add(prerequisites[i][0]);
		inDegree[prerequisites[i][0]]++;
	    }

	    Queue<Integer> queue = new LinkedList<>();
	    for (int i = 0; i < inDegree.length; i++) {
		if (inDegree[i] == 0) {
		    queue.add(i);
		}
	    }

	    while (!queue.isEmpty()) {
		int course = queue.poll();
		if (outMap.get(course) == null) {
		    continue;
		}

		for (int c : outMap.get(course)) {
		    inDegree[c]--;
		    if (inDegree[c] == 0) {
			queue.add(c);
		    }
		}
		outMap.remove(course);
	    }

	    return outMap.isEmpty();
	}
    }

    public class Solution_TopologicalSortBFS {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
	    if (numCourses < 1 || prerequisites == null || prerequisites.length == 0) {
		return true;
	    }

	    Map<Integer, Set<Integer>> inEdges = new HashMap<Integer, Set<Integer>>();
	    Map<Integer, Set<Integer>> outEdges = new HashMap<Integer, Set<Integer>>();
	    for (int i = 0; i < prerequisites.length; i++) {
		if (!inEdges.containsKey(prerequisites[i][0])) {
		    inEdges.put(prerequisites[i][0], new HashSet<Integer>());
		}
		inEdges.get(prerequisites[i][0]).add(prerequisites[i][1]);

		if (!outEdges.containsKey(prerequisites[i][1])) {
		    outEdges.put(prerequisites[i][1], new HashSet<Integer>());
		}
		outEdges.get(prerequisites[i][1]).add(prerequisites[i][0]);
	    }

	    LinkedList<Integer> queue = new LinkedList<Integer>();
	    for (int i = 0; i < numCourses; i++) {
		if (!inEdges.containsKey(i)) {
		    queue.offer(i);
		}
	    }

	    while (!queue.isEmpty()) {
		int course = queue.poll();
		if (!outEdges.containsKey(course)) {
		    continue;
		}
		for (int c : outEdges.get(course)) {
		    inEdges.get(c).remove(course);
		    if (inEdges.get(c).isEmpty()) {
			inEdges.remove(c);
			queue.offer(c);
		    }
		}
	    }

	    return inEdges.isEmpty();
	}
    }
}
