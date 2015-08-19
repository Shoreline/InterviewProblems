package snapchat;

/**
 * 一堆数，中间插入*，+或者括号，求最大值
 *
 */
/*
 * http://www.lostscroll.com/max-value-using-and/
 * 
 * 给出N个数字，不改变它们的相对位置，在中间加入K个乘号和N-K-1个加号，（括号随便加）使最终结果尽量大。因为乘号和加号一共就是N-1个了，
 * 所以恰好每两个相邻数字之间都有一个符号。例如：
 * 
 * N=5，K=2，5个数字分别为1、2、3、4、5，可以加成：
 * 
 * 1*2*(3+4+5)=24
 * 
 * 1*(2+3)*(4+5)=45
 * 
 * (1*2+3)*(4+5)=45
 * 
 * 
 * 动态规划
 * 
 * 状态 sum[i,j] 表示从第i位到第j位组成的数字
 * 
 * F[i,j] 表示把前i个数字分为j份乘积的最大值
 * 
 * 状态转移方程 F[i,j]=max{F[k,j-1]*sum[k+1,i]} (1<=k<=i-1)
 * 
 * 边界条件 F[x,1]=sum[1,x]
 * 
 * 目标结果 F[N,W]
 * 
 * 时间复杂度 O(K*N^2)
 * 
 * int main(){
    vector<vector<int> > f(n+1, vector<int>(n));
    vector<int> sum(n);
    int num[n]={1,2,3,1,1,1,5,6,1};
 
    for(int i=1;i<=n;i++){
        sum[i]=sum[i-1]+num[i-1];
        f[i][0]=sum[i];
    }
 
    int ans=INT_MIN;
    for(int i=2;i<=n;i++){
        for(int j=1;j<=i-1;j++){
            for(int k=j;k<=i-1;k++){
                f[i][j]=max(f[i][j],f[k][j-1]*(sum[i]-sum[k]));
            }
            if(i==n && f[n][j]>ans){
                ans=f[n][j];
            }
        }
    }
    printf("%d",ans);
    return 0;
}


Solution 2: 1D dp, O(N)
int maxExprResult(vector<int> A) {
    int n = A.size();
    vector<k>(n);
    k[0] = A[0];
    for (int i = 1; i < n; i++) {
        k[i] = max(k[i - 1] * A[i], (i >= 2 ? k[i - 2] : 1) * (A[i - 1] + A[i]));
        if (i >= 2) {
            k[i] = max(k[i], (i >= 3 ? k[i - 3] : 1) * (A[i - 2] + A[i - 1] + A[i]));
        }
    }
    return k[n-1];
}
 */
public class MaxValue {

}
