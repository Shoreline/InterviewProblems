package array;

import java.util.Arrays;

public class Sum {

    public static int kComplementary(int K, int[] A) {
	if (A == null || A.length < 2)
	    return 0;

	int count = 0;
	Arrays.sort(A);
	int i = 0;
	int j = A.length - 1;

	while (i <= j) {
	    int sum = A[i] + A[j];

	    if (sum == K) {
		if (i == j) {
		    count++;
		    break;
		} else if (A[i] == A[j]) {
		    /*
		     * if A={2,2,2,2} and K=4, then there are (3+2+1)*2+4 pairs
		     */
		    int diff = j - i - 1;
		    for (int m = diff - 1; m > 0; m++) {
			count += m * 2;
		    }
		    count += diff;
		    break;

		} else {
		    int x = i;
		    int y = j;
		    while (x < j && A[x] == A[i]) {
			x++;
		    }

		    while (y > i && A[y] == A[j]) {
			y--;
		    }

		    count += 2 * (x - i) * (j - y);
		    i = x;
		    j = y;
		}

	    } else if (sum < K) {
		i++;
	    } else {
		j--;
	    }

	}

	return count;
    }
}
