package string;

public class DistinctSubsequences {
    /**
     * Distinct Subsequences
     * 
     * Given a string S and a string T, count the number of distinct
     * subsequences of T in S.
     * 
     * A subsequence of a string is a new string which is formed from the
     * original string by deleting some (can be none) of the characters without
     * disturbing the relative positions of the remaining characters. (ie, ��ACE��
     * is a subsequence of ��ABCDE�� while ��AEC�� is not).
     * 
     * Here is an example: S = ��rabbbit��, T = ��rabbit�� Return 3.
     */

    /*
     * ���������Ǹ��������ַ���x��z. ������x���ж��ٸ�z.���Լ򵥵�DP���ϵ��ơ�����a[i][j]������j��ĸ���У����ֶ��ٸ�����Ϊi���Ӵ���
     * �����i����ĸ��j����ĸ����ͬ
     * �������ת��Ϊa[i][j]=a[i][j-1];�������Ϊ����Ϊi���Ӵ��ڳ���Ϊj��ĸ���ͳ���Ϊj-1��ĸ�����ִ�����ͬ��
     * �����i����ĸ��j����ĸ��ͬ
     * �������ת��Ϊa[i][j]=a[i][j-1]+a[i-1][j-1]�����Ϊ����i-1���Ӵ���j-1���Ӵ����ִ�����
     * ��ʼ��a[0][0]~a[0][s1.length()]Ϊ1,��0���ȵ��Ӵ���0��ĸ���г��ִ���Ϊ1��
     * �Ӵ�����100��ĸ��10000��������10��100�η�����java������
     */

    /*
     * DP thoughts
     */

    public static int numDistinct(String S, String T) {
	int[][] dp = new int[T.length() + 1][S.length() + 1];

	for (int i = 0; i <= S.length(); i++) {
	    dp[0][i] = 1;
	    dp[i][0] = 0; // it is unnecessary, but helps us understand
	}

	for (int i = 1; i <= T.length(); i++) {
	    for (int j = 1; j <= S.length(); j++) {
		if (S.charAt(j - 1) == T.charAt(i - 1)) {
		    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
		} else {
		    dp[i][j] = dp[i][j - 1];
		}
	    }
	}

	return dp[T.length()][S.length()];
    }
}
