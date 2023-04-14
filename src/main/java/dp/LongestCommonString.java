package dp;

import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/longest-common-subsequence/
 *
 * LCS：
 * 1 2 3 4 5 6 7
 * 1 3 5 7
 * LCS就是1357，顺序上严格递增，可以不连续。
 *
 * 最长公共子串长度：
 * 1、建模：X={X1,..,Xm},Y={Y1,...,Yn}
 *
 * 2、子问题是什么？x1->xm-1,
 * Xm=Yn,1+max(Xm-1,Yn-1)
 * Xm!=Yn,max{(Xm-1,Yn],[Xm,Yn-1]}
 * dp[i][j]:Xi,Yj
 *
 * 最优解+重复子问题->动态规划
 *
 * 3、DP转换方程
 *
 * db[i][j]:Xi,Yj字符串对应的最长公共子序列长度
 *
 * 	0 i=0或j=0
 * 	1+dp[i-1][j-1]  x[i]=y[j]，i>0&j>0
 * 	max{dp[i-1][j],dp[i][j-1]} x[i]!=y[j],i>0&j>0
 *
 * 	标志位来计算最长公共子序列：
 * 	x[i]=y[j] 副对角线方向移动一位；
 * 	x[i]!=y[j] dp[i-1][j] >= dp[i][j-1] 选择i方向移动一位
 * 	x[i]!=y[j] dp[i-1][j] <= dp[i][j-1] 选择j方向移动一位
 */
public class LongestCommonString {
    int lcs[][];
    Stack<Character> stack = new Stack<>();
    public static void main(String[] args) {
        LongestCommonString s = new LongestCommonString();
        String t1 = "1456",t2="456";
        int r = s.longestCommonSubsequence(t1,t2);
        System.out.println(r);

        //输出lcs
        s.lcsout(s.lcs,t1.length(),t2.length(),t1,t2);
        while (!s.stack.empty()){
            System.out.println(s.stack.pop());
        }
    }

    private void lcsout(int[][] lcs, int i, int j,String t1,String t2) {
        if(i == 0 || j == 0){
            return;
        }
        int flag = lcs[i][j];
        if(flag == 1){
            stack.push(t1.charAt(i-1));
            lcsout(lcs,i-1,j-1,t1,t2);
        }else if(flag==2){//t1方左移动一次
            lcsout(lcs,i-1,j,t1,t2);
        }else {
            lcsout(lcs,i,j-1,t1,t2);
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null){
            return 0;
        }
        //很重要：必须得有，否则int dp[][] = new int[l1][l2];这里l1为0，导致dp数组行数为空。
        if(text1.length() == 0 || text2.length() == 0){
            return 0;
        }
        int l1 = text1.length(), l2=text2.length();
        int dp[][] = new int[l1+1][l2+1];//有i-1和j-1时，建议从1开始遍历
        lcs = new int[l1+1][l2+1];//1 副对角线方向，2 左方向，3 右方向
        for(int i=0;i<=l1;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<=l2;j++){
            dp[0][j] = 0;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    lcs[i][j] = 1;//记录lcs字符串
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    if(dp[i-1][j]>=dp[i][j-1]){
                        lcs[i][j] = 2;
                    }else {
                        lcs[i][j] = 3;
                    }
                }
            }
        }
        return dp[l1][l2];
    }

}
