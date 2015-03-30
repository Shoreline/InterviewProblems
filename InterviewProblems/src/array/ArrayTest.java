package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import array.NextPermutation.Solution;

public class ArrayTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
	new ArrayTest().new Solution().minPathSum(new int[][]{{1,2},{1,1}});
    }

    public class Solution {
	    public int minPathSum(int[][] grid) {
	        if(grid == null || grid.length==0){
	            return -1;
	        }
	        
	        // actually better use the smaller one of m and n
	        int[] dp = new int[grid[0].length];
	        for(int i = 0; i<dp.length; i++){
	            dp[i]=grid[0][i];
	        }
	        for(int i = 1; i<grid.length; i++){
	            for(int j = 0; j<grid[0].length; j++){
	                int a = dp[j];
	                int b = (j>0? dp[j-1]:0);
	        	dp[j] = grid[i][j] + Math.min(dp[j],(j>0?dp[j-1]:0));
	            }
	        }
	        
	        return dp[dp.length-1];
	    }
    }
}
