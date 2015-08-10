package facebook;

/**
 * Implement function strstrp(String a, String b) returns index where any
 * permutation of b is a substring of a
 * 
 * strstrp("hello", ''ell") returns 1
 * 
 * strstrp("hello", "lle") returns 1
 * 
 * strstrp("hello", "wor") returns -1
 * 
 * Need O(N) time complexity
 *
 */


public class StrStrII {
    
    /*
     * Use Character[]
     * 
     * Character[], is the characters distribution for a.substring(i, i +
     * b.length()).
     * 
     * Of course, the Character[] for i can be calculated based on Character[] based
     * on i - 1 at O(1) cost.
     * 
     * -> so, eventually O(N*M) time complexity. M is the length of b. Since each
     * time to compare Character[] takes M time
     * 
     * -> If use some hash function instead of Character[] may O(N)? 
     * 
     * reference, not solution
     * 
     * http://coding-interview-archives.blogspot.com/2013/09/find-all-occurrences-of
     * -all.html
     */
}
