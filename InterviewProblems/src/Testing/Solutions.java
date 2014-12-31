package Testing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solutions {
    public static void main(String[] args) {
	/*
	 * Enter your code here. Read input from STDIN. Print output to STDOUT.
	 * Your class should be named Solution.
	 */

	Scanner in = new Scanner(System.in);

	String[] input = in.nextLine().split(" ");
	int n = Integer.valueOf(input[0]);
	int k = Integer.valueOf(input[1]);

	input = in.nextLine().split(" ");
	// int[] A = new int[input.length];
	// for (int i =0; i<input.length; i++){
	// A[i]=Integer.valueOf(input[i]);
	// }

	HashSet<Integer> hset = new HashSet<Integer>(input.length);
	for (int i = 0; i < input.length; i++) {
	    hset.add(Integer.valueOf(input[i]));
	}

	// Arrays.sort(A);
	int counter = 0;
	for (int i = 0; i < input.length; i++) {
	    int anInt = Integer.valueOf(input[i]);
	    if (hset.contains(anInt + k))
		counter++;
	    if (hset.contains(anInt - k))
		counter++;

	}

	System.out.print(counter / 2);

    }

    public class MyStackArray<E> {
	private int size = 0;
	private static final int DEFAULT_CAPACITY = 10;
	private Object elements[];

	public MyStackArray() {
	    elements = new Object[DEFAULT_CAPACITY];
	}

	public void push(E e) {
	    if (size == elements.length) {
		ensureCapa();
	    }
	    elements[size++] = e;
	}

	@SuppressWarnings("unchecked")
	public E pop() {
	    E e = (E) elements[--size];
	    elements[size] = null;
	    return e;
	}

	private void ensureCapa() {
	    int newSize = elements.length * 2;
	    elements = Arrays.copyOf(elements, newSize);
	}
    }
}
