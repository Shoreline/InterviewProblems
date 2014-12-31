package array;

public class MedianOfTwoSortedArrays {
    /**
     * Median of Two Sorted Arrays
     * 
     * There are two sorted arrays A and B of size m and n respectively. Find
     * the median of the two sorted arrays. The overall run time complexity
     * should be O(log (m+n)).
     */

    /*
     * very hard.
     * 
     * 
     * if m+n is an even number, return the average value of the two middle
     * elements
     */

    /*
     * http://fisherlei.blogspot.com/2012/12/leetcode-median-of-two-sorted-arrays
     * .html
     * 
     * [解题思路]
     * 
     * O(n)的解法比较直观，直接merge两个数组，然后求中间值。而对于O(log(m+n))显然是用二分搜索了， 相当于“Kth element
     * in 2 sorted array”的变形。如果(m+n)为奇数，那么找到“(m+n)/2+1 th element in 2 sorted
     * array”即可。如果（m+n）为偶数，需要找到(m+n)/2 th 及(m+n)/2+1 th，然后求平均。
     * 
     * 而对于“Kth element in 2 sorted array”， 如下图，两个中位数 A[m/2] 和 B[n/2]，
     * 可以将数组划分为四个部分。而丢弃哪一个部分取决于两个条件：1， (m/2 + n/2)?k；2，A[m/2] ? B[n/2];
     * 
     * 
     * 
     * 如果 (m/2 + n/2) > k，那么意味着，当前中位数取高了，正确的中位数要么在 Section 1或者Section3中。如果A[m/2]
     * > B[n/2], 意味着中位数肯定不可能在Section 2里面，那么新的搜索可以丢弃这个区间段了。同理可以推断出余下三种情况，如下所示：
     * 
     * If (m/2+n/2+1) > k && am/2 > bn/2 , drop Section 2 If (m/2+n/2+1) > k &&
     * am/2 < bn/2 , drop Section 4 If (m/2+n/2+1) < k && am/2 > bn/2 , drop
     * Section 3 If (m/2+n/2+1) < k && am/2 < bn/2 , drop Section 1
     * 
     * 
     * 简单的说，就是或者丢弃最大中位数的右区间，或者丢弃最小中位数的左区间。
     */
    // private static int getMedian(int[] A, int m1, int m2, int[] B,int n1, int
    // n2, int k){
    //
    // if( m2<=0) return B[k-1];
    // if( n2<=0) return A[k-1];
    //
    // if(k<=1) return Math.min(A[m1],B[n1]);
    //
    // if((m2-m1)/2+(n2-n1)/2 > k){
    // if(A[(m1+m2)/2] > B[(n1+n2)/2]){
    // return getMedian(A,m1,m2/2,B,n1,n2,k);
    // }
    // else{
    // return getMedian(A,m1,m2,B,n1,n2/2,k);
    // }
    // }
    // else{
    // if(A[(m1+m2)/2] > B[(n1+n2)/2]){
    // return getMedian(A, m1, m2, B, n1+n2/2+1, n2-(n2/2+1), k-(n2/2+1) );
    // }
    // else{
    // return getMedian(A, m1+(m2/2+1), m2-(m2/2+1), B, n1, n2, k-(m2/2+1));
    // }
    //
    // }
    // }

    public static void main(String[] args) {
	int[] A = new int[] { 4 };
	int[] B = new int[] { 1, 2, 3, 5, 6, 7 };
	int lenA = A.length;
	int lenB = B.length;

	int k = (lenA + lenB) / 2;
	if ((lenA + lenB) % 2 == 1)
	    k++;

	System.out.println(getMedian(A, 0, lenA, B, 0, lenB, k));
    }

    // private static int getMedian(int[] A, int m1, int m2, int[] B, int n1,
    // int n2, int k) {
    //
    // if (m2 - m1 <= 0)
    // return B[n1 + k - 1];
    // if (n2 - n1 <= 0)
    // return A[m1 + k - 1];
    //
    // if (k <= 1)
    // return Math.min(A[m1], B[n1]);
    //
    // if ((m2 - m1) / 2 + (n2 - n1) / 2 + 1 >= k) {
    // if (A[(m1 + m2) / 2] >= B[(n1 + n2) / 2]) {
    // return getMedian(A, m1, m2 / 2, B, n1, n2, k);
    // } else {
    // return getMedian(A, m1, m2, B, n1, n2 / 2, k);
    // }
    // } else {
    // if (A[(m1 + m2) / 2] >= B[(n1 + n2) / 2]) {
    // return getMedian(A, m1, m2, B, n1 + n2 / 2 + 1, n2
    // - (n2 / 2 + 1), k - (n2 / 2 + 1));
    // } else {
    // return getMedian(A, m1 + (m2 / 2 + 1), m2 - (m2 / 2 + 1), B,
    // n1, n2, k - (m2 / 2 + 1));
    // }
    //
    // }
    // }
    private static int getMedian(int[] A, int m1, int m2, int[] B, int n1,
	    int n2, int k) {

	if (m2 - m1 <= 0)
	    return B[n1 + k - 1];
	if (n2 - n1 <= 0)
	    return A[m1 + k - 1];

	if (k <= 1)
	    return Math.min(A[m1], B[n1]);

	if ((m2 - m1) / 2 + (n2 - n1) / 2 + 1 >= k) {
	    if (A[(m1 + m2) / 2] > B[(n1 + n2) / 2]) {
		return getMedian(A, m1, m2 / 2, B, n1, n2, k);
	    } else {
		return getMedian(A, m1, m2, B, n1, n2 / 2, k);
	    }
	} else {
	    if (A[(m1 + m2) / 2] > B[(n1 + n2) / 2]) {
		return getMedian(A, m1, m2, B, n1 + n2 / 2 + 1, n2, k
			- ((n2 - n1) / 2 + 1));
	    } else {
		return getMedian(A, m1 + (m2 / 2 + 1), m2, B, n1, n2, k
			- ((m2 - m1) / 2 + 1));
	    }

	}
    }

}
