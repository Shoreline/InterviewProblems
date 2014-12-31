package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Triplets {
    /**
     * Triplets
     * 
     * 
     * There is an integer array d which does not contain more than two elements
     * of the same value. How many distinct ascending triples (d[i] < d[j] <
     * d[k], i < j < k) are present?
     * 
     * Input format The first line contains an integer N denoting the number of
     * elements in the array. This is followed by a single line containing N
     * integers separated by a single space with no leading/trailing spaces
     * 
     * Output format: A single integer that denotes the number of distinct
     * ascending triples present in the array
     * 
     * Constraints: N <= 10^5
     * 
     * Every element of the array is present at most twice
     * 
     * Every element of the array is a 32-bit positive integer
     * 
     * Sample input:
     * 
     * 6
     * 
     * 1 1 2 2 3 4
     * 
     * Sample output: 4
     * 
     * Explanation: The distinct triplets are (1,2,3) (1,2,4) (1,3,4) (2,3,4)
     * 
     */

    /*
     * unfinished
     */

    public static void main(String[] args) {
	/*
	 * Enter your code here. Read input from STDIN. Print output to STDOUT.
	 * Your class should be named Solution.
	 */
	Scanner in = new Scanner(System.in);

	// Scanner has nextInt() method!
	String[] input = in.nextLine().split(" ");

	int len = Integer.valueOf(input[0]);

	input = in.nextLine().split(" ");

	int[] A = new int[input.length];
	for (int i = 0; i < input.length; i++) {
	    A[i] = Integer.valueOf(input[i]);
	}

	HashSet<Integer> hset = new HashSet<Integer>();

	// Arrays.sort(A); Shall NOT sort A!
	boolean[] occupancy = new boolean[A.length];

	HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();

	triplets(result, A, new int[3], occupancy, 0, 0);

	for (ArrayList<Integer> aList : result) {
	    System.out.println(aList.toString());
	}

    }

    private static void triplets(HashSet<ArrayList<Integer>> result, int[] A,
	    int[] temp, boolean occupancy[], int amount, int index) {

	if (amount == 3) {
	    ArrayList<Integer> newList = new ArrayList<Integer>();
	    for (int i = 0; i < amount; i++) {
		newList.add(temp[i]);
	    }
	    result.add(newList);
	    return;
	}

	for (int i = index; i < A.length; i++) {

	    if (amount == 0 && occupancy[i] != true) {
		temp[amount] = A[i];
		// amount++;
	    } else if (A[i] > temp[amount - 1] && occupancy[i] != true) {
		temp[amount] = A[i];
		// amount++;
	    } else {
		continue;
	    }
	    occupancy[i] = true;
	    triplets(result, A, temp, occupancy, amount + 1, i + 1);
	    occupancy[i] = false;
	}

    }
}