package dp;

/**
 * https://leetcode.cn/problems/edit-distance/
*给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
*
* 你可以对一个单词进行如下三种操作：
*
* 插入一个字符
* 删除一个字符
* 替换一个字符
*
*
* 示例 1：
*
* 输入：word1 = "horse", word2 = "ros"
* 输出：3
* 解释：
* horse -> rorse (将 'h' 替换为 'r')
* rorse -> rose (删除 'r')
* rose -> ros (删除 'e')
 *
 * 1、建模 X={X1,...Xm},c[i][j] Xi与Y[j]的最短距离,Xi->转为Yj
 * 2、子问题：
 * 如果Xi=Yj，此时不需要做处理，c[i]c[j]=c[i-1][j-1]
 * 如果Xi!=Yj，可以有插入、删除、替换3种选择，
 *  插入：Yj已经被替换，向右移动一位，c[i]c[j]=1+c[i][j-1]
 *  删除：Xi少了1位，向右移动一位，c[i]c[j]=1+c[i-1][j]
 *  替换：c[i]c[j]=1+c[i-1][j-1]
 * c[0][j]=j//base case
 * c[i][0]=i//base case
 *  3、伪代码
 *
 */
public class BianJiJuLi {
    public static void main(String[] args) {
        String w1 = "intention", w2 = "execution";
        System.out.println(minDistance(w1,w2));
    }

    public static int minDistance(String word1, String word2) {
        if(word1 == null && word2 == null){
            return 0;
        }
        if(word1 == null || word1.length() == 0){
            return word2.length();
        }
        if(word2 == null || word2.length() == 0){
            return word1.length();
        }
        int l1 = word1.length(), l2 = word2.length();
        int c[][] = new int[l1+1][l2+1];
        //base case 赋值，很重要 ！！！
        for (int i = 0; i <= l1; i++) {
            c[i][0] = i;
        }
        for (int j = 0; j <= l2; j++) {
            c[0][j] = j;
        }
        //状态转换方程，很重要 ！！！
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2 ; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    c[i][j] = c[i-1][j-1];
                }else {
                    c[i][j] = Math.min(Math.min(1+c[i][j-1],1+c[i-1][j]),1+c[i-1][j-1]);
                }
            }
        }
        return c[l1][l2];
    }
}
