package array;

import java.util.ArrayList;

public class SurroundedHoles {
    /**

    Consider a n x n checkboard. Each square is colored either black or
    white.  A _region_ of the checkboard is any collection of contiguous
    squares. Two squares are *not* considered contiguous if they share a
    corner but do not share an edge. A region is a _hole_ if all its
    squares are white and if every edge not totally within the region is
    either on the checkboard boundary or is shared by a black square. For
    example, the checkboard below contains 8 holes.

    [
      [1, 0, 1, 1, 1, 1, 1, 0, 1, 1],
      [1, 1, 1, 0, 0, 1, 0, 0, 1, 1],
      [0, 1, 0, 0, 1, 1, 0, 0, 0, 0],
      [0, 1, 1, 0, 1, 0, 0, 0, 0, 0],
      [1, 0, 1, 0, 1, 1, 1, 0, 0, 0],
      [1, 0, 1, 1, 1, 0, 1, 0, 0, 0],
      [1, 0, 0, 0, 0, 0, 1, 0, 0, 0],
      [1, 1, 1, 1, 1, 1, 1, 0, 0, 0],
      [0, 0, 0, 1, 0, 1, 1, 0, 0, 0],
      [0, 0, 0, 0, 1, 0, 1, 0, 0, 0]
    ]

    Your job is to write a function that receives a two dimensional array
    like the one above and it finds the number of holes in the checkboard,
    printing the number of white squares in each hole. For the checkboard
    above, the function should print that there are 8 holes, containing 1,
    1, 1, 2, 6, 7, 8 and 30 white squares. The holes might be printed in
    any order.

    **/
    
    public static void main(String[] args){
	int arr[][]={
		      {1, 0, 1, 1, 1, 1, 1, 0, 1, 1},
		      {1, 1, 1, 0, 0, 1, 0, 0, 1, 1},
		      {0, 1, 0, 0, 1, 1, 0, 0, 0, 0},
		      {0, 1, 1, 0, 1, 0, 0, 0, 0, 0},
		      {1, 0, 1, 0, 1, 1, 1, 0, 0, 0},
		      {1, 0, 1, 1, 1, 0, 1, 0, 0, 0},
		      {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
		      {1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
		      {0, 0, 0, 1, 0, 1, 1, 0, 0, 0},
		      {0, 0, 0, 0, 1, 0, 1, 0, 0, 0}
		    };
	System.out.println("running...");
	SurroundedHoles haha = new SurroundedHoles();
	System.out.println(haha.findHoles(arr).toString());
    }


    public ArrayList<Integer> findHoles(int arr[][]) {
	ArrayList<Integer> result = new ArrayList<Integer>();
	if (arr == null)
	    return result;

	boolean visited[][] = new boolean[arr.length][arr[0].length];
	for (int i = 0; i < arr.length; i++) {
	    for (int j = 0; j < arr[0].length; j++) {
		int value = checkElements(arr, visited, i, j, 0);
		if (value > 0) {	// only add to result when we found a hole having area > 0
		    result.add(value);
		}
	    }
	}

	return result;
    }
    
    private int checkElements(int arr[][], boolean visited[][],int i, int j, int result) {	    
	// check indices validation and whether an element has already been visited
	if ((i >= arr.length || i < 0) || (j >= arr[0].length || j < 0)
		|| visited[i][j]) {
	    return 0;
	}

	visited[i][j] = true;	// avoid counting an element repeatedly
	
	// if an element is white, we shall check its four surrounding elements
	if (arr[i][j] == 0) {	    
	    result += 1+ checkElements(arr, visited, i - 1, j, result)
		    + checkElements(arr, visited, i, j - 1, result)
		    + checkElements(arr, visited, i + 1, j, result)
		    + checkElements(arr, visited, i, j + 1, result);
	}
	return result;
    }

/**
{
  {0, 0, 1},
  {0, 1, 0},
  {0, 0, 0}
}

1) anElement: (0,0) set (0,0)
2) result = 1
3) set (0,0), (1, 0), (0,1)
4) anElement: (1,0); set (0,0), (1, 0), (0,1)
5) result = 2
6) set (0,0), (1, 0), (0,1)
**/

//    private int checkElements(int arr[][], boolean visited[][],Set<Element> eleSet, int result) {
//	// int result = 0;
//	for (Element anElement : eleSet) {
//	    int i = anElement.i;
//	    int j = anElement.j;
//	    
//	    if(visited[i][j]){
//		continue;
//	    }
//
//	    visited[i][j] = true;
//	    eleSet.remove(anElement);
//	    if (arr[anElement.i][anElement.j] == 0) {
//		// check boundaries and whether visited already
//		// eleSet.add(new Element(i - 1, j)); no need to check elements
//		// before
//		
//		if (j - 1 >= 0) {
//		    eleSet.add(new Element(i, j - 1));
//		}
//
//		if (i + 1 < arr.length) {
//		    eleSet.add(new Element(i + 1, j));
//		}
//
//		if (j + 1 < arr[0].length) {
//		    eleSet.add(new Element(i, j + 1));
//		}
//		result = checkElements(arr, visited, eleSet, 0) + 1;
//	    } else {
//		result += checkElements(arr, visited,eleSet, 0);
//	    }
//
//	}
//
//	return result;
//    }

    

}
