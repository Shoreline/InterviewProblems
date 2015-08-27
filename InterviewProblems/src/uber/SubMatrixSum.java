package uber;

/*
 * DP.
 * 
 * sum(ABCD) = sum(OD) - sum(OB) - sum(OC) + sum(OA)
 * 
 * sum(ABCD): The summation of element values in rectangular A,B,C,D
 * sum(OD): the summation of element values in rectangular O,D. O is the top left point of the whole matrix.
 * 
 * Need some pre-processing: sum[i][j] to save sum(OX). X is of (i,j)
 */
public class SubMatrixSum {

}
