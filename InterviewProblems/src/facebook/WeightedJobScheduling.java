package facebook;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Weighted Job Scheduling
 * 
 * Given N jobs where every job is represented by following three elements of
 * it. 1) Start Time 2) Finish Time. 3) Profit or Value Associated. Find the
 * maximum profit subset of jobs such that no two jobs in the subset overlap.
 * 
 * Example:
 * 
 * Input: Number of Jobs n = 4. Job Details {Start Time, Finish Time, Profit}
 * 
 * Job 1: {1, 2, 50}
 * 
 * Job 2: {3, 5, 20}
 * 
 * Job 3: {6, 19, 100}
 * 
 * Job 4: {2, 100, 200}
 * 
 * Output: The maximum profit is 250. We can get the maximum profit by
 * scheduling jobs 1 and 4.
 *
 */

/*
 * local-global maximum.
 * 
 * Time: O(N^2); Space: O(N)
 * 
 * dp[i]: the maximum profit of job_0 ~ job_i, must including job_i.
 * 
 * http://www.geeksforgeeks.org/weighted-job-scheduling/ 
 */

class Job {
    int start;
    int end;
    int profit;

    public Job(int start, int end, int profit) {
	super();
	this.start = start;
	this.end = end;
	this.profit = profit;
    }
}

public class WeightedJobScheduling {
    class Solution {
	int findMaxProfit(Job[] jobs) {
	    if (jobs == null || jobs.length == 0) {
		return 0;
	    } else if (jobs.length == 1) {
		return jobs[0].profit;
	    }

	    Arrays.sort(jobs, new Comparator<Job>() {
		@Override
		public int compare(Job j1, Job j2) {
		    return j1.end - j2.end;
		}
	    });

	    int[] dp = new int[jobs.length];
	    dp[0] = jobs[0].profit;
	    int max = dp[0];

	    for (int i = 1; i < jobs.length; i++) {
		int j = i - 1;
		while (j >= 0 && jobs[j].end > jobs[i].start) {
		    j--;
		}

		dp[i] = jobs[i].profit + (j >= 0 ? jobs[j].profit : 0);
		max = Math.max(max, dp[i]);
	    }

	    return max;
	}
    }

    public static void main(String[] args) {
	Job[] jobs = new Job[] { new Job(3, 10, 20), new Job(1, 2, 50),
		new Job(6, 19, 100), new Job(2, 100, 200) };
	System.out.println(new WeightedJobScheduling().new Solution()
		.findMaxProfit(jobs));
    }
}
