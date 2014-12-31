package array;

public class MergeSortedArray {
    /**
     * Merge Sorted Array
     * 
     * Given two sorted integer arrays A and B, merge B into A as one sorted
     * array.
     * 
     * Note: You may assume that A has enough space to hold additional elements
     * from B. The number of elements initialized in A and B are m and n
     * respectively.
     */
    /*
     * correct solution: Start from the end of both arrays. Fill the larger one
     * starting from A[n+m-1]
     */
    /*
     * Second round. one time pass!
     * 
     * note: take care the boundary situations: when all original elements of A
     * or B has been filled in A, how to deal witht the other array
     */
    public void merge2(int A[], int m, int B[], int n) {
	// Start typing your Java solution below
	// DO NOT write main() function

	if (A == null || B == null)
	    return;

	int i = m + n - 1;

	while (i >= 0) {

	    if (n - 1 < 0)
		break;

	    if (m - 1 < 0) {
		A[i] = B[n - 1];
		i--;
		n--;
		continue;
	    }

	    if (A[m - 1] >= B[n - 1]) {
		A[i] = A[m - 1];
		m--;
		i--;
	    } else {
		A[i] = B[n - 1];
		n--;
		i--;
	    }

	}

	return;

    }

    public static void merge(int A[], int m, int B[], int n) {
	/*
	 * Since A has enough space to hold all elements, we assume it is not
	 * null nor empty
	 */
	if (B == null || B.length == 0)
	    return;

	int ptrA = m - 1;
	int ptrB = n - 1;
	int ptrC = m + n - 1;

	while (ptrA >= 0 && ptrB >= 0) {
	    if (A[ptrA] > B[ptrB]) {
		A[ptrC] = A[ptrA];
		ptrA--;
	    } else {
		A[ptrC] = B[ptrB];
		ptrB--;
	    }
	    ptrC--;
	}

	if (ptrB >= 0) {
	    for (int i = ptrB; i >= 0; i--) {
		A[ptrC] = B[i];
		ptrC--;
	    }
	}
    }

    /*
     * My thought: need to use both A and B as cache. Switch element values
     * between A and B? -> not a good way
     */
    public static void mergeUnfinished(int A[], int m, int B[], int n) {
	if (B == null || B.length == 0)
	    return;
	// Since A has enough space to hold all elements, we assume it is not
	// null nor empty

	if (A == null || A.length == 0) {
	    for (int i = 0; i < n; i++) {
		A[i] = B[i];
	    }
	    return;
	}

	int Bptr2 = -1;
	int Bptr = 0;
	int Aptr = 0;
	while (Aptr <= m + n) {
	    int Amin = 0;
	    int Bmin = 0;
	    if (Bptr2 >= 0) {
		Amin = B[Bptr2];
		Bmin = B[Bptr];
	    } else {
		Amin = A[Aptr];
		Bmin = B[Bptr];
	    }

	    if (Amin < Bmin) {
		if (Bptr2 == -1) {
		    Aptr++;
		    continue;
		}

		A[Aptr] = Amin;
		Bptr2++;
	    } else {
		B[Bptr] = A[Aptr];
		A[Aptr] = Bmin;
		Bptr++;
		if (Bptr > n) {
		    Aptr++;
		    break;
		}
	    }
	    Aptr++;
	}
    }
}
