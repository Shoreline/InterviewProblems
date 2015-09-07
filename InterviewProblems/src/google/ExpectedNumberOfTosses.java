package google;

/**
 * Write a function to return expected number of tosses of an unbiased or biased
 * coin until there are m (>= 1) heads in a row,supposing the head probability
 * in a toss is p: 0 < p <= 1. If the result is not integer, round it.
 * 
 *
 */

/*
 * http://stats.stackexchange.com/questions/85606/closed-form-recurrence-formula
 * -for-getting-n-consecutive-heads-on-a-coin
 * 
 * E(K) = p*( E(K-1) + 1 ) + (1-p)*( E(K-1) + 1 + E(K) )
 * 
 * -> E(K) = (1 + E(k-1))/p
 * 
 * 
 * E(0) = 0 
 */
public class ExpectedNumberOfTosses {

}
