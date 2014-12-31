package array;

public class CoverMatrix {
    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     */

    /*
     * We notice:
     * 
     * 1. The number of smaller rectangles are just enough to cover the whole
     * matrix
     * 
     * 2. Only two possibilities to place a small rectangle: 1x2 or 2x1
     * 
     * -> f(n)=f(n-1) + f(n-2) --> Fibonacci sequence
     */
}
