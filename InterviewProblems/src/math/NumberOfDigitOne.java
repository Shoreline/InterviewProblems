package math;

/**
 * Number of Digit One
 * 
 * Given an integer n, count the total number of digit 1 appearing in all
 * non-negative integers less than or equal to n.
 * 
 * For example: Given n = 13, Return 6, because digit 1 occurred in the
 * following numbers: 1, 10, 11, 12, 13.
 * 
 * Hint: Beware of overflow.
 *
 */
public class NumberOfDigitOne {

    /*
     *
     * 
     *
     * for example 42345: preRound is 2345's # of 1 digits; preFull is 9999's #
     * of 1 digits; preExtraOnes is 10000; pre is 2345+1.
     *
     */
    public class Solution2 {
	public int countDigitOne(int n) {
	    if (n <= 0) {
		return 0;
	    }

	    int curRound = 0, preRound = 0, preFull = 0;
	    int multiplier = 1, preExtraOnes = 1, pre = 1;

	    while (n > 0) {
		int num = n % 10;

		if (num > 1) {
		    curRound = num * preFull + preRound + preExtraOnes;
		} else if (num == 1) {
		    curRound = num * preFull + preRound + pre;
		}

		preFull = 10 * preFull + preExtraOnes;
		preExtraOnes *= 10;
		pre += num * multiplier;
		multiplier *= 10;
		n /= 10;
		preRound = curRound;
	    }
	    return preRound;
	}
    }

    public class Solution {
	public int countDigitOne(int n) {
	    if (n <= 0)
		return 0;
	    int preRound = 0, preAll = 0;
	    int multiplier = 1, preNums = 1, pre = 1;
	    while (n > 0) {
		int curr = n % 10;
		if (curr > 1)
		    preRound = curr * preAll + preRound + preNums;
		else if (curr == 1)
		    preRound = curr * preAll + preRound + pre;
		preAll = 10 * preAll + preNums;
		preNums *= 10;
		pre += curr * multiplier;
		multiplier *= 10;
		n /= 10;
	    }
	    return preRound;
	}
    }
}
