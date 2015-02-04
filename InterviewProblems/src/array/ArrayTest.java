//package array;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//
//import string.TextJustification;
//
//public class ArrayTest {
//
//    /**
//     * @param args
//     */
//    public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	long startTime = System.currentTimeMillis();
//
//	NQueens.solveNQueens(4);
//
//	HashSet<String> hahaha = new HashSet<String>();
//
//	hahaha.add("hot");
//	hahaha.add("dot");
//	hahaha.add("dog");
//	hahaha.add("lot");
//	hahaha.add("log");
//	WordLadderII.findLadders("hit", "cog", hahaha);
//
//	LongestIncreasingSequence.getLIS(new int[] { 35, 36, 39, 3, 15, 27, 6,
//		42 });
//	LongestIncreasingSequence.getLISLength(new int[] { 35, 36, 39, 3, 15,
//		27, 6, 42 });
//
//	LargestRectangleInHistogram.largestRectangleArea(new int[] { 0, 2, 0 });
//
//	int aa = Sum.kComplementary(6, new int[] { 1, 1, 4, 5, 6 });
//
//	NextPermutation.nextPermutation(new int[] { 1, 3, 2 });
//
//	// 7, 1, 2, 3, 4, 5, 6
//	// 3, 4, 5, 6, 7, 1, 2
//	SearchInRotatedSortedArray_Storm8.getSmallest(new int[] { 1, 2, 3, 4,
//		5, 6, 7 });
//
//	//ThreeSum.threeSum(new int[] { 0, 0, 0 });
//
//	TwoSum.twoSum(new int[] { 5, 75, 25 }, 100);
//
//	int[] input = { -1, 0, 1, 2, -1, -4 };
//
//	// get0SumFrom3(input); // Java only compare the references of two
//	// arrays
//	// System.err.println("=============");
//	//ThreeSum.get0SumFrom3_2(input);
//
//	System.out.println("=============");
//	Integer[] input2 = { 1, 1, 1, 1 };
//	//System.out.println(ThreeSumClosest.Solutio.getThreeSumCloest(input2, 5));
//
//	System.out.println("=============");
//	int[] input3 = { 1, 0, -1, 0, -2, 2 };
//	//ArrayList<ArrayList<Integer>> result = FourSum.fourSum(input3, 0);
//	for (ArrayList<Integer> aResult : result) {
//	    System.out.println(aResult);
//	}
//
//	System.out.println("=============");
//	int[] input4 = { 3, 4, 9, 14, 15, 19, 28, 37, 47, 50, 54, 56, 59, 61,
//		70, 73, 78, 81, 92, 95, 97, 99 };
//	result = SubSetsCUE.getSets(input4);
//	for (ArrayList<Integer> aResult : result) {
//	    System.out.println(aResult);
//	}
//	System.out.println(result.size());
//
//	System.out.println("=============");
//	int[] input5 = { 2, 3, 6, 7 };
//	result = CombinationSum.combinationSum(input5, 7);
//	for (ArrayList<Integer> aResult : result) {
//	    System.out.println(aResult.toString());
//	}
//
//	System.out.println("=============");
//	input5 = new int[] { 10, 1, 2, 7, 6, 1, 5 };
//	result = CombinationSum2.combinationSum2(input5, 8);
//	for (ArrayList<Integer> aResult : result) {
//	    System.out.println(aResult.toString());
//	}
//
//	System.out.println("=============");
//	input5 = new int[] { 1, 2 };
//	BestTimeToBuyAndSellStock3.maxProfitB(input5);
//
//	System.out.println("=============");
//	input5 = new int[] { 5, 75, 25 };
//	int[] haha = TwoSum.twoSum(input5, 100);
//	for (int k = 0; k < haha.length; k++) {
//	    System.out.println(haha[k]);
//	}
//
//	System.out.println("=============");
//	System.out.println(PermutationSequence.getPermutation(4, 5));
//
//	System.out.println("=============");
//	input5 = new int[] { 1, 2, 3 };
//	result = Permutations.permute1(input5);
//	for (ArrayList<Integer> aResult : result) {
//	    System.out.println(aResult.toString());
//	}
//
//	System.out.println("=============");
//	input5 = new int[] { 1, 2, 2 };
//	result = Permutations2.permute1(input5);
//	for (ArrayList<Integer> aResult : result) {
//	    System.out.println(aResult.toString());
//	}
//
//	System.out.println("=============");
//	input4 = new int[] { 3, 9 };
//	result = Subsets.subsets(input4);
//	for (ArrayList<Integer> aResult : result) {
//	    System.out.println(aResult);
//	}
//
//	System.out.println("======Subsets2=======");
//	input4 = new int[] { 1, 1 };
//	result = Subsets2.subsetsWithDup(input4);
//	for (ArrayList<Integer> aResult : result) {
//	    System.out.println(aResult);
//	}
//
//	System.out.println("======Text Justification=======");
//	String[] inputStr = new String[] { "What", "must", "be", "shall", "be." };
//	ArrayList<String> resultStr = TextJustification.fullJustify(inputStr,
//		12);
//	for (String aResult : resultStr) {
//	    System.out.println(aResult);
//	}
//
//	System.out.println("======Spiral Matrix=======");
//	int[][] input6 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
//	// input6 = new int[][] { { 1 } };
//	System.out.println(SpiralMatrix.spiralOrder(input6));
//	input6 = new int[][] { { 1 } };
//	System.out.println(SpiralMatrix.spiralOrder(input6));
//	input6 = new int[][] { { 1, 2 }, { 3, 4 } };
//	System.out.println(SpiralMatrix.spiralOrder(input6));
//	System.out.println(SpiralMatrix.spiralOrder(null));
//
//	System.out.println("\n======Spiral Matrix 2=======");
//	input6 = SpiralMatrix2.generateMatrix(4);
//	for (int i = 0; i < input6.length; i++) {
//	    for (int j = 0; j < input6[0].length; j++) {
//		System.out.print(input6[i][j] + "\t");
//	    }
//	    System.out.print("\n");
//	}
//
//	System.out.println("\n======Search In Rotated Sorted Array=======");
//	int[] A = new int[] { 1, 3 };
//	System.out.println(SearchInRotatedSortedArray.search(A, 0));
//
//	long endTime = System.currentTimeMillis();
//	System.out.println("Running time: " + (double) (endTime - startTime)
//		/ 1000 + "s");
//    }
//}
