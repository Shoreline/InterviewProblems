package math;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Count Primes
 * 
 * Description:
 * 
 * Count the number of prime numbers less than a non-negative number, n
 * 
 * click to show more hints.
 * 
 * References: How Many Primes Are There?
 * 
 * Sieve of Eratosthenes
 *
 */
public class CountPrimes {
    /*
     * Eratosthenes algorithm
     * 
     * Can use bitmap to optimize space
     * 
     * primes[k] indicates whether Integer k is a prime. In this way primes[0]
     * and primes[1] is wasted, but easier to understand
     */
    public class Solution {
	public int countPrimes(int n) {
	    boolean[] primes = new boolean[n];
	    Arrays.fill(primes, true);

	    int count = 0;
	    for (int i = 2; i < n; i++) {
		if (primes[i]) {
		    count++;

		    int j = 2;
		    while (i * j < n) {
			primes[i * j] = false;
			j++;
		    }
		}
	    }

	    return count;
	}
    }

    // used TreeSet, the remove() is too slow. TLE.
    public class Method_1 {
	public int countPrimes(int n) {
	    if (n < 1) {
		return 0;
	    }

	    TreeSet<Integer> primes = new TreeSet<Integer>();
	    for (int i = 1; i < n; i++) {
		primes.add(i);
	    }

	    int p = 2;
	    while (p < Math.sqrt(primes.last())) {

		Iterator<Integer> itr = primes.iterator();
		while (itr.hasNext()) {
		    Integer num = itr.next();
		    if (num % p == 0) {
			itr.remove(); // cost O(logn)
		    }
		}

		/*
		 * throw concurrent modification exception for (int num :
		 * primes) { if (num % p == 0) { primes.remove(num); } }
		 */
		p = primes.higher(p);
	    }

	    return primes.size();
	}
    }
}
