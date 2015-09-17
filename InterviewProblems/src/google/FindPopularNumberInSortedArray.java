package google;

/**
 * find the most popular number in an array of Integer. The 'popular number' is
 * defined as the number occurs more than n/4, where n is the length of array.
 * The array is already sorted
 * 
 */

/*
 * Note the number occurs more than n/4 is not necessarily the result. There may
 * be other even more popular number.
 * 
 * The result must be one of num[n/4], num[2*n/4], or num[3*n/4].
 * 
 * -> if any two of them are the same, then it is the result
 * 
 * -> if not, use binary search to check the ranges of these 3 numbers
 */
public class FindPopularNumberInSortedArray {

}
