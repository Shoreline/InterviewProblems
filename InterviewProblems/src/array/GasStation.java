package array;

/**
 * Gas Station
 * 
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * 
 * Note: The solution is guaranteed to be unique.
 *
 */

/*
 * http://blog.csdn.net/linhuanmars/article/details/22706553
 * 
 * Since there is only one possible result, it must be the beginning of a
 * positive segment. (if not, any positive stations before it and also in this
 * positive segment are also possible)
 * 
 * It is safe to reset start = i+1 if segNet<0. If the last stop is the one
 * causing segnet<0, then the totalNet must < 0 and will return -1
 */
public class GasStation {
    /*
     * Easier to understand
     */
    public class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
	    if (gas == null || gas.length == 0) {
		return -1;
	    }
	    // else if (gas.length==1){
	    // return 0;
	    // }

	    int costSum = cost[0];
	    int gasSum = gas[0];
	    int start = 0;
	    int curGas = gas[0];
	    for (int i = 1; i < gas.length; i++) {
		costSum += cost[i];
		gasSum += gas[i];
		curGas -= cost[i - 1];
		if (curGas < 0) {
		    start = i;
		    curGas = gas[i];
		} else {
		    curGas += gas[i];
		}

	    }

	    return gasSum >= costSum ? start : -1;
	}
    }

    public class Solution2 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
	    if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
		return -1;
	    }

	    int totalNet = 0;
	    int segmentNet = 0;
	    int start = 0;
	    for (int i = 0; i < gas.length; i++) {
		int net = gas[i] - cost[i];
		totalNet += net;
		segmentNet += net;

		if (segmentNet < 0) {
		    start = i + 1; // safe
		    segmentNet = 0;
		}
	    }

	    return totalNet >= 0 ? start : -1;
	}
    }

}
