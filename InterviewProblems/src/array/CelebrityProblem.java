package array;

public class CelebrityProblem {
    /**
     * Celebrity Problem
     * 
     * You have a room with n people. A celebrity walks in. Everyone knows the
     * celebrity, the celebrity knows no one. Non-celebrities may/may not know
     * anyone in the room. Give an algorithm to find the celebrity. Discuss the
     * complexity.
     */

    public int getCelebrity(int[] A) {

	int candidateIndex = 0;

	/*
	 * if A[index] knows A[i], then A[index] must not be a celebrity;
	 * 
	 * if A[index] does not know A[i], then A[i] must not be a celebrity.
	 */
	for (int i = 1; i < A.length; i++) {
	    if (haveAcquaintance(A[candidateIndex], A[i])) {
		candidateIndex = i;
	    }
	}

	// make sure if A[index] is a celebrity
	for (int i = 0; i < A.length; i++) {
	    if (i == candidateIndex)
		continue;

	    // A[index] shall not know everyone
	    if (haveAcquaintance(A[candidateIndex], A[i]))
		return -1;

	    // everyone shall know A[index]
	    if (!haveAcquaintance(A[i], A[candidateIndex]))
		return -1;
	}

	return candidateIndex;
    }

    // assume this method tells whether a knows b
    private static boolean haveAcquaintance(int a, int b) {
	return true;
    }
}
