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
        System.out.println(superEggDrop(2,6));
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
                int min = Integer.MAX_VALUE;
                //每一层都扔，最终提交leetcode超时，O(K*N^2)
//                for (int l = 1; l <= j; l++) {
//                    min = Math.min(Math.max(1+c[i-1][l-1],1+c[i][j-l]),min);
//                }
//                c[i][j] = min;
                //改进算法：二分查找扔，不从第一层向上扔，而是先从中间楼层扔，如果蛋碎了，向下找中间楼层，如果蛋没碎，向上找中间楼层
                int left = 1, right = j;
                while (left<=right){
                    int mid = (left+right)/2;//选择mid层开始扔
                    int broken = 1+c[i-1][mid-1];
                    int notBroken = 1+c[i][j-mid];
                    if(broken>notBroken){//蛋碎
                        right = mid - 1;
                        min = Math.min(broken,min);
                    }else if (broken<notBroken){//蛋未碎
                        left = mid+1;
                        min = Math.min(notBroken,min);
                    }else {//精华：当broken=notBroken时，可以确认c[i][j]就是最小值，无需再寻找。
                        //min = Math.min(Math.max(1+c[i-1][l-1],1+c[i][j-l]),min);自变量是l，当l增加时，c[i-1][l-1]单调递增，因为l越大，需要试的次数越多；
                        // 1+c[i][j-l]单调递减，所以两线交点就是两者的最小值。
                        min = Math.min(broken,min);
                        break;
                    }
//                    if(broken>=notBroken){//错误
//                        right = mid - 1;
//                        min = Math.min(broken,min);
//                    }else {
//                        left = mid+1;
//                        min = Math.min(notBroken,min);
//                    }
                }
                c[i][j] = min;
            }
        }
        return c[k][n];
    }
}
