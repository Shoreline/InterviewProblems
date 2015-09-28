package google;

/**
 * First, "i" represents increase, "d" represents decrease, so for number 123,
 * the sequence would be "ii", for number 87123, sequence would "ddii".
 * 
 * The question is to generate the minimum number follows given sequence, say "iidd".
 *
 */

/*
 * char c = input.charAt(i);
 * 
 * if c== 'i', just add i+1 to the end;
 * 
 * if c == 'd', insert i+1 before previous insertion point
 * 
 * say, for 12435 (iidi):
 * if the next char is 'i', then 124356 (iidii);
 * else, since 5 is previous insertion, insert 6 before it: 124365 (iidid)
 * 
 * use linkedlist to get O(1) insertion speed?
 */
public class TrendSequenceWithMinValue {

}
