package google;

import java.util.Arrays;

public class _Test {

    public static void main(String[] args) {
		
	System.out.println(new LongestIncreasingContinuousSubSequence().new Solution().longestIncreasingContinuousSubsequence(new int[]{5, 4, 2, 1, 3}));
	
	int[][] a = new int[][]{{1,2,3},{4,5,6}};
	int[]b = Arrays.copyOf(a[0], a[0].length); // copyOf() generates a new int[]
	//b = Arrays.copyOf(a[0], a[0].length);
	b[0]=100;
	for(int[] i :a){
	    System.out.println(Arrays.toString(i));
	}
	System.out.println(Arrays.toString(b));
    }

}
