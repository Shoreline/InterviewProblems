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
	// Solution haha = new NextPermutation().new Solution();
	// haha.nextPermutation(new int[] { 3, 2, 1 });
	List<Integer> wahaha = new ArrayList<Integer>();
	List<Integer> yahaha = new ArrayList<Integer>();
	Collections.sort(wahaha);
	wahaha.add(1);
	yahaha.addAll(wahaha);
	wahaha.remove(0);

	System.out.println(wahaha.equals(yahaha));

	Set<List<Integer>> okok = new HashSet<List<Integer>>();
	List<List<Integer>> lala = new ArrayList<List<Integer>>();
	lala.addAll(0, okok);
	okok.add(yahaha);
	okok.add(wahaha);
	System.out.println(okok);

    }

   
}
