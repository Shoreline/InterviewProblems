package google;

/**
 * Josephus problem
 * 
 * People are standing in a circle waiting to be executed. Counting begins at a
 * specified point in the circle and proceeds around the circle in a specified
 * direction. After a specified number of people are skipped, the next person is
 * executed. The procedure is repeated with the remaining people, starting with
 * the next person, going in the same direction and skipping the same number of
 * people, until only one person remains, and is freed.
 * 
 * The problem; given the number of people, starting point, direction, and
 * number to be skipped, is to choose the position in the initial circle to
 * avoid execution.
 */
/*
 * http://maskray.me/blog/2013-08-27-josephus-problem-two-log-n-solutions
 */
public class ExecutePrisoner {
    /*
     * n: number of people in circle
     * 
     * m: kill one person every m ppl ( so skip m-1 ppl between each two kills)
     * 
     * Assume f(n) is the index of an element when there are n people in
     * circle), then f(n+1)= ( f(n) + m )%(n+1)
     * 
     * The initial case is n=1 (the last left person), with index f(1) = 0 (or
     * 1, does not matter). We can then keep computing till reach f(n)
     */
}
