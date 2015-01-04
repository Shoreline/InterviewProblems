package array;

/*
 * The tricky part is to distinguish how to handle index and size/length
 */
public class KthElementOfTwoSortedArray {
    public static void main(String[] args) {
	int[] A = new int[] { 1, 2 };
	int[] B = new int[] { 1, 2 };

	System.out.println(solution2.findMedianSortedArrays(A, B));
    }
  
    /**
     * Solution2: The best solution, simple and true O(log(m+n)) speed.
     * http://www.acmerblog.com/leetcode-median-of-two-sorted-arrays-5330.html
     */
    static class solution2 {
	public static double findMedianSortedArrays(int A[], int B[]) {
	    int k = A.length + B.length;
	    if (k % 2 == 1) {
		return getKthElementFromTwoSortedArrays(A, 0, B, 0, k / 2 + 1);
	    } else {
		double a = getKthElementFromTwoSortedArrays(A, 0, B, 0, k / 2);
		double b = getKthElementFromTwoSortedArrays(A, 0, B, 0,
			k / 2 + 1);
		return (a + b) / 2;
	    }

	}

	/*
	 * The k-th element of an array C is C[k-1]; k start from 1. Variables m
	 * and n are two pointers.
	 * 
	 * Main idea: 
	 * exclude a certain fore part of one of the input arrays each time. 
	 * 
	 * Boundary conditions are: 
	 * 1) one of the input array is empty; 
	 * 2) k = 1. In this case we just need to find out the smallest element of input arrays
	 * 
	 * Each iteration, consider the first k elements of the combined array.
	 * Assume among these k elements, there are pa elements from A[] and pb from B[].
	 * So k = pa + pb 	(1)
	 * 
	 * The best way is to set pa = pb = k/2, but sometimes A.length or B.length is smaller than k/2.
	 * To avoid unnecessary trouble, let the length of B[] always <= length of A[].
	 * So set pb = min(k/2, B.length);
	 * 
	 * The indice of pa elements in A[] is A[0],...A[pa-1], similar for pb elments in B[].
	 * Check the biggest elements, A[pa-1] and B[pb-1]:
	 * If A[pa-1]==B[pb-1], then A[pa-1] or B[pb-1] is the answer.
	 * If A[pa-1]>B[pb-1], then among these k elements (pa+pb=k) there are at least 1 element bigger than B[pb-1] (which is A[pa-1]).
	 * So there are at most k-1 elements <=B[pb-1], means B[pb-1] is at most the (k-1)th element in combined array
	 * Thus, we can exclude B[0]~B[pb-1], they are impossible to be the k-th element
	 * 
	 */
	private static double getKthElementFromTwoSortedArrays(int A[], int m,
		int B[], int n, int k) {
	    int sizeA = A.length - m;
	    int sizeB = B.length - n;

	    // let sizeA always >= sizeB
	    if (sizeA < sizeB) {
		return getKthElementFromTwoSortedArrays(B, n, A, m, k);
	    }

	    if (sizeB == 0) {
		return A[m + k - 1];
	    } else if (k == 1) {
		return Math.min(A[m], B[n]);
	    }

	    int pb = Math.min(k / 2, sizeB);
	    int pa = k - pb;

	    /*
	     * At this point, k>1 and sizeB>0 For elements A[m] ~ A[m+pa-1] and
	     * B[n]~B[n+pb-1], if any of them has a
	     */

	    if (A[m + pa - 1] > B[n + pb - 1]) {
		return getKthElementFromTwoSortedArrays(A, m, B, n + pb, k - pb);
	    } else if (A[m + pa - 1] < B[n + pb - 1]) {
		return getKthElementFromTwoSortedArrays(A, m + pa, B, n, k - pa);
	    } else {
		return A[m + pa - 1];
	    }
	}
    }

    /**
     * Solution1: The accuracy has not been completed verified. Below code get
     * exceed time limit error on LeetCode question find median of two sorted
     * arrays.
     */
    static class solution1 {
	public static double findMedianSortedArrays(int A[], int B[]) {
	    int m = 0;
	    if (A != null) {
		m = A.length;
	    }

	    int n = 0;
	    if (B != null) {
		n = B.length;
	    }

	    if (m == 0 && n == 0) {
		return 0;
	    }
	    // the K-th element in the combined array
	    int k = (m + n) % 2 == 0 ? (m + n) / 2 - 1 : (m + n) / 2;
	    System.out.println("k= " + k);
	    return getMedian(A, 0, m - 1, B, 0, n - 1, k);
	}

	/*
	 * m1/m2 are the indice of start/end elements of a subset array of A
	 */
	private static double getMedian(int A[], int m1, int m2, int B[],
		int n1, int n2, int k) {
	    System.out.println(m1 + " " + m2 + " " + n1 + " " + n2 + " " + k);

	    if (m1 > m2) {
		return B[n1 + k];
	    }

	    if (n1 > n2) {
		return A[m1 + k];
	    }

	    if (k <= 0) {
		return Math.min(A[m1], B[n1]);
	    }

	    if (A[(m1 + m2) / 2] > B[(n1 + n2) / 2]) {
		if (k > (m2 - m1) / 2 + (n2 - n1) / 2) {
		    return getMedian(A, m1, m2, B, (n1 + n2) / 2 + 1, n2, k
			    - (n2 - n1) / 2 - 1);
		} else {
		    return getMedian(A, m1, (m1 + m2) / 2 - 1, B, n1, n2, k);
		}
	    } else {
		if (k > (m2 - m1) / 2 + (n2 - n1) / 2) {
		    return getMedian(A, (m2 - m1) / 2 + 1, m2, B, n1, n2, k
			    - (m2 - m1) / 2 - 1);
		} else {
		    return getMedian(A, m1, m2, B, n1, (n1 + n2) / 2 - 1, k);
		}
	    }

	}
    }
    
    /**
     * Solution3: unverified
     * 
     * The idea is that let i and j elements in A[] and B[] are the first k elements
     * Randomly set i, so j=k-i; (boundary conditions shall be handled beforehand)
     * If A[i]>=B[j-1] and B[j]>=A[i-1] then we find the solution. Otherwise move i.
     */
    static class solution3 {
	public static double findMedian(int A[], int B[]) {
	    int m = 0;
	    if (A != null) {
		m = A.length;
	    }

	    int n = 0;
	    if (B != null) {
		n = B.length;
	    }

	    if ((m + n) % 2 == 1) {
		return findIndexK(A, B, (m + n) / 2);
	    } else {
		double a = findIndexK(A, B, (m + n) / 2);
		double b = findIndexK(A, B, (m + n) / 2 - 1);
		return (a + b) / 2;
	    }
	}

	private static double findIndexK(int A[], int B[], int k) {
	    int m = 0;
	    if (A != null) {
		m = A.length;
	    }

	    int n = 0;
	    if (B != null) {
		n = B.length;
	    }

	    if (k >= m + n - 1) {
		return Double.MIN_VALUE;
	    }
	    if (m == 0 && n == 0) {
		return Double.MIN_VALUE;
	    } else if (m == 0) {
		return B[k];
	    } else if (n == 0) {
		return A[k];
	    }

	    /*
	     * i >= 0 & i<= m-1; j >= 0 & j<= n-1; i+j = k
	     */
	    int iMin = Math.max(0, k - n + 1);
	    int iMax = Math.min(k, m - 1);

	    int i = iMin;

	    while (iMin <= iMax) {
		int j = k - i;

		if (A[i] >= B[j - 1] && A[i - 1] <= B[j]) {
		    return A[i];
		} else if (A[i - 1] > B[j]) { // i is too big
		    i = (iMin + i) / 2;
		} else {
		    i = (i + iMax) / 2;
		}
	    }

	    return 0;
	}
    }
}
