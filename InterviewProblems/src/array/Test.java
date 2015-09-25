package array;

import java.util.Arrays;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
	int[][] rooms = new int[][]{{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
	new WallsAndGates().new Solution().wallsAndGates(rooms);
	int[] nums = new int[]{3, 5, 2, 1, 6, 4};
	new WiggleSort().new Solution().wiggleSort(nums);
	System.out.println(Arrays.toString(nums));

    }

}
