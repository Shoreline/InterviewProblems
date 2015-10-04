package array;

import java.util.Arrays;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
	int[][]board = new int[][]{{1,1},{1,0}};
	new GameOfLife().new Solution().gameOfLife(board);

    }

}
