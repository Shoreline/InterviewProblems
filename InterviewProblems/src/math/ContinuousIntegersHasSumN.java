package math;

import java.util.ArrayList;

public class ContinuousIntegersHasSumN {
    /**
     * http://zhedahht.blog.163.com/blog/static/25411174200732711051101/
     * 
     * ����Ա�����⾫ѡ100 ��(26)-��Ϊn ������������
     * 
     * ��Ŀ������һ������n��������к�Ϊn �����������С�
     * 
     * ��������15������1+2+3+4+5=4+5+6=7+8=15���������3 ����������1-5��4-6 ��7-8��
     */

    /*
     * Sliding window.
     * 
     * if sum<N, j++; if sum>N, i++
     */
    public static ArrayList<ArrayList<Integer>> getSequence(int N) {

	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	int i = 1;
	int j = 1;

	int sum = 0;

	while (i <= N / 2) {
	    if (sum == N) {
		// ...
		ArrayList<Integer> aList = new ArrayList<Integer>();
		aList.add(i);
		aList.add(j - 1);
		result.add(aList);
		sum -= i;
		i++;
	    }

	    if (sum < N) {
		sum += j;
		j++;

	    } else {
		sum -= i;
		i++;
	    }
	}

	ArrayList<Integer> itselft = new ArrayList<Integer>();
	itselft.add(N);
	result.add(itselft);

	return result;
    }
}
