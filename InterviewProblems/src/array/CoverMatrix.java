package array;

public class CoverMatrix {
    /**
     * ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
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
