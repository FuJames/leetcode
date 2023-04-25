package dp;

/**
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 *
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 *
 * 假设每一种面额的硬币有无限个。
 *
 * 题目数据保证结果符合 32 位带符号整数。
 *
 * 示例 1：
 *
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 * 思路：动态规划，
 * 1、建模
 *  硬币分类：C={C1,...,Ci}
 *  总和：A 总金额
 *  d[i][j]：i种硬币，总金额为j，凑成的组合数量
 * 2、子问题
 *  对于每个硬币，我可以选择使用或不使用，
 *  case 1:如果当前硬币面额Ci>A，则不能使用它,d[i][j]=d[i-1][j]，第1->i-1种硬币，总和为j
 *  case 2:如果当前硬币面额小于A，分为使用此硬币或不使用此硬币，最终是不使用和使用的组合数之和，d[i][j]=d[i][j-Ci]+d[i-1][j]
 *  case 3:如果当前硬币面额等于A，使用此硬币或不使用此硬币，与case 2相同，d[i][j]=d[i][j-Ci]+d[i-1][j]
 */
public class LingQianDuiHuan {
    public static void main(String[] args) {
        int a = 5;
        int c[] = new int[]{1,2,5};
        System.out.println(change(a,c));
    }
    public static int change(int amount, int[] coins) {
        if(amount < 0){
            return 0;
        }
        if(coins == null || coins.length == 0){
            return 0;
        }
        int len = coins.length;
        int d[][] = new int[len+1][amount+1];
        //base case:需注意！！ 如果amount为0，不需要任何硬币，即1种组合；注意不是0，0代表组合不出来。
//        for (int i = 0; i < len; i++) {//错误点：少了d[len]的初始化
        for (int i = 0; i <= len; i++) {
            d[i][0] = 1;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= amount ; j++) {
                int c = coins[i-1];
                if(c > j){
                    d[i][j] = d[i-1][j];
                }else{
                    d[i][j]=d[i][j-c]+ d[i-1][j];
                }
            }
        }

        return d[len][amount];
    }
}
