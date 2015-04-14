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
	
	System.out.println(new ArrayTest().removeDuplicates(new int[]{1}));
    }

    public int removeDuplicates(int[] A) {
        if(A==null|| A.length==0){
            return 0;
        }
        
        int ptr=1;
        int counter = 1;
        for(int i = 1; i<A.length; i++){
            if(A[i]==A[i-1]){
                counter++;
            }
            else{
                counter=1;
            }
            
            if(counter<=2){
                A[ptr]=A[i];
                ptr++;
            }
        }
        
        return ptr+1;
    }
}
