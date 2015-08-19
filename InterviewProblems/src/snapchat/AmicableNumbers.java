package snapchat;

import java.util.*;

/**
 * 亲和数问题最早是由毕达哥拉斯学派发现和研究的。他们在研究数字的规律的时候发现有以下性质特点的两个数：
 * 
 * 220的真因子是：1、2、4、5、10、11、20、22、44、55、110；
 * 
 * 284的真因子是：1、2、4、71、142。
 * 
 * 而这两个数恰恰等于对方的真因子各自加起来的和（sum[i]表示数i 的各个真因子的和），即
 * 
 * 220=1+2+4+71+142=sum[284],
 * 
 * 284=1+2+4+5+10+11+20+22+44+55+110=sum[220]。
 * 
 * 得284的真因子之和sum[284]=220，且220的真因子之和sum[220]=284，即有sum[220]=sum[sum[284]]=284。
 *
 */
public class AmicableNumbers {
    class Method {
	List<Integer[]> getAmicablePairs(int n) {
	    List<Integer[]> res = new ArrayList<Integer[]>();
	    int sum[] = new int[n + 1];
	    int i, j;

	    Arrays.fill(sum, 1); // 1是所有数的真因数所以全部置1

	    for (i = 2; i + i <= n; i++) // 预处理，预处理是logN（调和级数）*N。
	    // @litaoye：调和级数1/2 + 1/3 + 1/4......的和近似为ln(n)，
	    // 因此O(n *(1/2 + 1/3 + 1/4......)) = O(n * ln(n)) = O(N*log(N))。
	    {
		// n以下最大的真因数是不超过它的一半的
		j = i + i; // 因为真因数，所以不能算本身，所以从它的2倍开始
		while (j <= n) {
		    // 将所有i的倍数的位置上加i
		    sum[j] += i;
		    j += i;
		}
	    }

	    for (i = 2; i <= n; i++) // 扫描，O（N）。
	    {
		// 一次遍历
		if (sum[i] > i && sum[i] <= n && sum[sum[i]] == i) {
		    // 去重，不越界，满足亲和
		    Integer[] ans = new Integer[] { i, sum[i] };
		    res.add(ans);
		}
	    }
	    return res;
	}
    }
}
