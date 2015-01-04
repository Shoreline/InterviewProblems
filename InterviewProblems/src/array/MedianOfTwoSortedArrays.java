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
     * [����˼·]
     * 
     * O(n)�Ľⷨ�Ƚ�ֱ�ۣ�ֱ��merge�������飬Ȼ�����м�ֵ�������O(log(m+n))��Ȼ���ö��������ˣ� �൱�ڡ�Kth element
     * in 2 sorted array���ı��Ρ����(m+n)Ϊ������ô�ҵ���(m+n)/2+1 th element in 2 sorted
     * array�����ɡ����m+n��Ϊż����Ҫ�ҵ�(m+n)/2 th ��(m+n)/2+1 th��Ȼ����ƽ��
     * 
     * ����ڡ�Kth element in 2 sorted array���� ����ͼ��������λ�� A[m/2] �� B[n/2]��
     * ���Խ����黮��Ϊ�ĸ����֡�������һ������ȡ��������������1�� (m/2 + n/2)?k��2��A[m/2] ? B[n/2];
     * 
     * 
     * 
     * ��� (m/2 + n/2) > k����ô��ζ�ţ���ǰ��λ��ȡ���ˣ���ȷ����λ��Ҫô�� Section 1����Section3�С����A[m/2]
     * > B[n/2], ��ζ����λ��϶���������Section 2���棬��ô�µ��������Զ�����������ˡ�ͬ������ƶϳ��������������������ʾ��
     * 
     * If (m/2+n/2+1) > k && am/2 > bn/2 , drop Section 2 If (m/2+n/2+1) > k &&
     * am/2 < bn/2 , drop Section 4 If (m/2+n/2+1) < k && am/2 > bn/2 , drop
     * Section 3 If (m/2+n/2+1) < k && am/2 < bn/2 , drop Section 1 
     * 
     * 
     * �򵥵�˵�����ǻ��߶��������λ�������䣬���߶�����С��λ�������䡣
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
