package facebook;

import java.util.*;

/**
 * 给两个vectors, 例如{0,3,2} 和{1,3,5}。 那么dot product 就是 0*1+3*3+2*5 ＝ 19 。
 * 那么如果每个vector 有millions of elements, 怎样优化 可以让 running time 比 o(n) 小
 * 
 * 
 * A,B化简成list of tuples (non-zero index, non-zero value) 然后two pointer扫就行
 * 
 * 这个题应该还有一个follow up是如果A中有10000个non-zero, B中只有100个non-zero，这个时候就是binary search
 * follow up，就是A中的非零比B中的多很多，就现在A中找B[0]，找到的话就再从A[index of B[0]：]中找B[1]依次类推
 */
/*
 * 假设A=[0,0,1,2,0,0,4]那么化简后就是[(2,1), (3,2), (6,4)], (2,1) 2是在A中的index, 1是A[2]
 * 
 * 假设B化简后是[(3,3),(5,1)] 要找到A[1] -> (3,2) B[0] -> (3,3). From 1point 3acres bbs
 * 然后 sum += 2*3这样,所以用two pointer follow up就是通过bi
 * search找到(3,2)然后再找(5,1)的时候我就只search A[2:]这部分
 */
public class DotProduct {
    List<int[]> haha = new ArrayList<>();
}
