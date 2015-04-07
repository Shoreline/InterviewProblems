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
	
	new NQueens().new Solution().solveNQueens(1);
    }

    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0||word == null||word.length()==0){
            return false;
        }
    
        
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length;j++){
                char c = word.charAt(0);
                if(board[i][j]==c){
                    board[i][j]='.';
                    if(dfs(board,word,0,i,j)){
                        return true;
                    }
                    else{
                        board[i][j]=c;
                    }
                }        
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][]board, String word, int pos, int i, int j){
        if(pos == word.length()){
            return true;
        }
        char c = word.charAt(pos);
        if(i>0 && board[i-1][j]==c){
            board[i-1][j]='.';
            if(dfs(board,word,pos+1,i-1,j)){
                return true;
            }
            board[i-1][j] = c;
        }
        
        if(i+1<board.length && board[i+1][j]==c){
            board[i+1][j]='.';
            if(dfs(board,word,pos+1,i+1,j)){
                return true;
            }
            board[i+1][j] = c;
        }
        
        if(j>0 && board[i][j-1]==c){
            board[i][j-1]='.';
            if(dfs(board,word,pos+1,i,j-1)){
                return true;
            }
            board[i][j-1] = c;
        }
        
        if(j+1<board[0].length && board[i][j+1]==c){
            board[i][j+1]='.';
            if(dfs(board,word,pos+1,i,j+1)){
                return true;
            }
            board[i][j+1] = c;
        }
        
        return false;
    }
}
