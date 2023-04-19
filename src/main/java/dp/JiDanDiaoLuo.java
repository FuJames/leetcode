package dp;

/**
 * https://leetcode.cn/problems/super-egg-drop/description/
 * 给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 *
 * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
 *
 * 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 *
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 *
 *
 * 示例 1：
 *
 * 输入：k = 1, n = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，肯定能得出 f = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，肯定能得出 f = 1 。
 * 如果它没碎，那么肯定能得出 f = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 f 是多少。
 */

import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.Map;

/**
 * 解题思路：暴力解法二分查找，前提是有无限多个鸡蛋。
 * 1、建模：K个鸡蛋，N个楼层，K={K1,...,Ki}，N={N1,...,Nj}，F 楼层，N>F，鸡蛋碎，N<=F 鸡蛋完好
 * 2、子问题：如何找出f？ 如果只有1个鸡蛋，只能从第一层开始扔，一直向上找；如果有无限个鸡蛋，可以从中间楼层二分扔，减少确认次数；如果是k个鸡蛋，可以选择任意楼层来扔；
 * 总结下来，最暴力的解法是，初始选择从第1到N层扔鸡蛋，计算每一层找到确切f的最坏情况次数，取所有楼层最坏情况的最小值。
 * 定义：c[i][j]定义为i个鸡蛋，j个楼层确认f的最小次数；从第i层开始扔鸡蛋，最坏情况次数L={L1,...,Li}；
 * 如果从l楼开始扔，1<=l<=j,有以下两种情况,
 *  1 鸡蛋碎 1+c[i-1][l-1] 向下找
 *  2 鸡蛋未碎 1+c[i][j-l] 鸡蛋可以继续用，向上找
 * 最坏情况次数Lj = max(1+c[i-1][l-1],1+c[i][j-l])
 * c[i][j]=min(L1,...,Lj)
 * //c[0][j] = 0//base case 定义错误；0个鸡蛋时，不在我们的考虑范围内，基础应该是1个鸡蛋，如果只有1个鸡蛋，要找到确切值，注意是一定能找到f，这里
 * 只能从第一层一层层往上找，找完所有楼层，才能确切找到f。
 * c[1][j]=j
 * c[i][0] = 0
 */
public class JiDanDiaoLuo {
    public static void main(String[] args) {
        System.out.println(superEggDrop(3,14));
    }
    public static int superEggDrop(int k, int n) {
        if(k <= 0){
            return 0;
        }
        if(n <= 0){
            return 0;
        }
        if(k == 1){
            return n;
        }
        int c[][] = new int[k+1][n+1];
        for (int i = 0; i <= k; i++) {
            c[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            c[1][j] = j;
        }
        Map<String,Integer> tmp = new HashMap<>();
        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= n ; j++) {
//                int min = Integer.MAX_VALUE;
                c[i][j] = Integer.MAX_VALUE;
                for (int l = 1; l <= j; l++) {
//                    min = Math.min(Math.max(1+c[i-1][l-1],1+c[i][j-l]),min);//提交超时
                    c[i][j] = Math.min(Math.max(1+c[i-1][l-1],1+c[i][j-l]),c[i][j]);//提交超时
                }
//                c[i][j] = min;
            }
        }
        return c[k][n];
    }
}
