package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 */
public class Threesum {
    public List<List<Integer>> threeSum(int[] nums) {
        //使用排序+双指针法；
        List<List<Integer>> list = new ArrayList<>();
        //边界判定
        if(nums == null || nums.length < 3){
            return list;
        }
        //数组排序
        Arrays.sort(nums);
        //双指针夹逼法和判重
        for(int i = 0 ; i < nums.length - 2 ; i ++){
            if(nums[i] > 0){
                continue;
            }
            //判重，如果nums[i-1]==nums[i],则无需遍历，因为值相等，第i-1个遍历的结果一定包含了第i个。
            if(i > 0 && nums[i-1] == nums[i]){
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            int target = -nums[i];
            while (l < r){
                if(nums[l] + nums[r] < target){
                    l++;
                } else if(nums[l] + nums[r] == target){
                    List<Integer> subList = new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r]));
                    list.add(subList);
                    l++;
                    r--;
                    //需要去除重复元素
                    while (l < r && nums[l] == nums[l - 1]){
                        l ++;
                    }
                    //错误点1：nums[r]==nums[r-1]做比较，应该是r与r+1做比较
//                    while (l < r && nums[r] == nums[r -1 ]){
                    while (l < r && nums[r] == nums[r + 1]){
                        r --;
                    }
                }else {
                    r --;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int a[] = new int[]{-2,0,1,1,2};

        Threesum ts = new Threesum();
        System.out.println(ts.threeSum(a));

    }
}
