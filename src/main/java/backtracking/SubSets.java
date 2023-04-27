package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 回溯算法：记住回溯就是循环+递归遍历决策树，试想下你遇到一个岔路口，不知道哪个才是终点，你需要尝试每一个岔路口，
 * 就需要下每个岔路口，先找一个岔路口尝试，再回头找另一个岔路口。
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * 思路：回溯，回溯框架，递归回溯树；
 * for 选择列表
 *  选择一个元素，添加到路径列表；
 *  递归
 *  撤销选择，从路径列表中删除；
 */
public class SubSets {
    private LinkedList<Integer> track = new LinkedList<>();
    private LinkedList<List<Integer>> result = new LinkedList<>();
    public static void main(String[] args) {
        int n[] = new int[]{0};
        SubSets ss = new SubSets();
        ss.subsets(n,0);
        System.out.println(ss.result);
    }
    /**
     * 决策树：
     */
    public void subsets(int[] nums,int start){
        if(nums==null||nums.length==0||start<0){
            return;
        }
        //子集的场景：每个track列表，都需要添加到结果列表中；
        //由于track是公共对象，数据会被更改，需要new 一个新的list 对象出来；
        result.add(new LinkedList<Integer>(track));
        for(int i=start;i<nums.length;i++){//精髓！ 每一层决策树的可选择列表，由[start,nums.length) 区间来决定
            track.addLast(nums[i]);//选择第i个元素，添加到路径表
            subsets(nums,i+1);//递归选择
            track.removeLast();//撤销选择，回溯的精髓，是换个选择
        }
    }
}
