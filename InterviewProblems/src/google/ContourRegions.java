package google;

/**
 * Given a black and white image represented as a matrix, process the image
 * in-place that only keeps the contour of the black region and turn all the
 * inside pixels to white.
 * 
 * 他强调了image可能很大，所以需要考虑怎样节约memory。
 *
 * input matrix is a 2d boolean array
 */

public class ContourRegions {
    /*
     * 一个黑色cell可以被标记为白色，当且仅当 上下左右四个方向的相邻cells都为黑色。 用o表示白色，*表示黑色.
     * 
     * 对于一行，例如 ooo****ooo，我们可知中间的*的左右都被黑色包围，那么只有他的上下相邻的cells都为黑色，它才可被标记为白色。
     * 对于每行，我们用两个数组，分别记录它上下两行的的初始情况。这就避免了修改前面的cell对后面的产生影响。
     * 
     * 用n表示行数，m表示列数。 复杂度是O(n*m)， 空间复杂度O(m)。
     * 
     * 还有一个小优化，如果n < m，我们就按列处理，结果是一样的， 但是空间复杂度更低，这种情况下空间复杂度O(min(m,n))
     */
}
