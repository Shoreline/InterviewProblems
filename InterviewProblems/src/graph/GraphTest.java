package graph;

public class GraphTest {

    public static void main(String[] args) {
	int[][] haha = new int[][] { new int[] { 5, 8 }, new int[] { 3, 5 },
		new int[] { 1, 9 }, new int[] { 4, 5 }, new int[] { 0, 2 },
		new int[] { 1, 9 }, new int[] { 7, 8 }, new int[] { 4, 9 } };
	System.out
		.println(new CourseSchedule().new Solution_TopologicalSortBFS()
			.canFinish(10, haha));
    }

}
