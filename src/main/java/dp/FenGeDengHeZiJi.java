package dp;

/**
 *给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 示例 1：
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *
 * 思路：需要将问题转换为0-1背包问题，
 * 给⼀个可装载重量为 sum / 2 的背包和 N 个物品，每个物品的重量为 nums[i] 。现在让你装物品，是否存在⼀种装法，能够恰好将背包装满？
 * 1、建模：背包重量W，每个物品的重量N={N1,...,Ni}
 * 2、子问题：对于每个物品，有如下子问题，
 *  如果当前物品重量小于背包重量，放入背包，子问题变为：d[i][j]=d[i-1][j-N[i]]
 *  如果当前物品重量大于背包重量，不能放入背包：d[i][j]=d[i-1][j]
 *  如果当前物品重量等于背包重量：d[i][j]=true
 *  如果背包重量W=0，d[i][0]=true；
 *  如果物品数量为0，即0个物品，d[0][j]=false；
 */
public class FenGeDengHeZiJi {
    public static void main(String[] args) {
        int n[] = new int[]{1,2,3,5};
        System.out.println(canPartition(n));
    }
    public static boolean canPartition(int[] nums) {
        if(nums == null || nums.length <= 1){
            return false;
        }
        int len = nums.length, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum % 2 != 0){//奇数总和返回false，很重要! 转换为背包问题前，必须要判定奇数总和
            return false;
        }
        int t = sum/2;

        boolean d[][] = new boolean[len+1][t+1];
        for (int i = 0; i < len; i++) {
            d[i][0] = true;
        }
        for (int j = 0; j < t; j++) {
            d[0][j] = false;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= t ; j++) {
                int tmp = i-1;
                if(j > nums[tmp]){//背包重量能放下第i个物品
                    d[i][j] = d[i-1][j-nums[tmp]] || d[i-1][j];
                }else if (j== nums[tmp]){//背包正好能放下第i个物品
                    d[i][j] = true;
                }else {//背包放不下第i个物品，只能从换个物品
                    d[i][j] = d[i-1][j];
                }
            }
        }
        return d[len][t];
    }
}
