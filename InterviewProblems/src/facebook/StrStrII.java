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

/*
 * 在a的每个位置截取c=a.substring(i,i+m) ，把c每个字符和次数存进hashmap,然后拿b来对比
 * 时间复杂度是O(m),总时间复杂度是O(mn)
 */
public class StrStrII {

}
