package main.java.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fuqianzhong
 * @date 2020/7/25
 * Two Sum.py
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 */
public class TwoSum {
    /**
     * 思路一：暴力解法，选定一个元素，遍历剩下元素o(n^2)
     * 思路二：排序，再从低位和高位2边，夹逼法，o(nlogn)
     * 思路三：使用map存储数组元素的下标(on，空间on)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length <= 1){
            return nums;
        }
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        Integer index = 0;
        for(;index < nums.length; index++){
            map.put(nums[index],index);
        }
        Integer e2Index = 0;
        for(index = 0; index < nums.length;index++){
            //错误一：index参数与map返回的索引相同，结果集中返回2个相同的索引，提交出错
//            if((e2Index = map.get(target - nums[index])) != null){
            //正确解法，对map返回索引与index做比较，如果不同才算成功。题目前提是只有一组结果。
            if((e2Index = map.get(target - nums[index])) != null && !e2Index.equals(index)){
                result[0] = index;
                result[1] = e2Index;
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] source = new int[1];
        source[0] = 0;
        twoSum.twoSum(source,9);
    }
}
