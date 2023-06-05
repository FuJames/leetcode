package math;

/**
 * 136. 只出现一次的数字
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 */
public class SingleNumber136 {
    /**
     * 线性时间；常量空间。
     * 思路：只有一个数字出现一次，剩余数字都只出现2次，异或逻辑。
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result=nums[0];
        for (int i = 1; i < nums.length; i++) {
            result=result^nums[i];
        }
        return result;
    }
}
