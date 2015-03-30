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
	new ArrayTest().new Solution().generateMatrix(2);
    }

    public class Solution {
	 public int[][] generateMatrix(int n) {
	        
	        if(n<0){
	            return null;
	        }
	        
	        int[][] res = new int[n][n];
	        
	        int top = 0;
	        int bottom = n-1;
	        int left = 0;
	        int right = n-1;
	        
	        int c = 1;
	        while(top<=bottom && left<=right){
	            for(int i = left; i<=right; i++){
	                res[i][top] = c*c;
	                c++;
	            }
	            
	            for(int i = top+1; i<=bottom-1; i++){
	                res[i][right] = c*c;
	                c++;
	            }
	            
	            if(left!=right){
	            for(int i = right; i>=left;i--){
	                res[bottom][i] = c*c;
	                c++;
	            }
	            }
	            
	            if(top!=bottom){
	            for(int i = bottom-1;i>=top+1; i--){
	                res[i][left] = c*c;
	                c++;
	            }
	            }
	            
	            top++;
	            bottom--;
	            left++;
	            right--;
	        }
	        
	        return res;
	        
	    }
    }
}
