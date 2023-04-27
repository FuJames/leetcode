package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * 中等
 * 2.5K
 * 相关企业
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 */
public class CombinationSum {
    private LinkedList<Integer> track = new LinkedList<>();
    private List<List<Integer>> result = new LinkedList<>();
    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        cs.combinationSum(new int[]{2,3,6,7},7);
        for (List<Integer> l : cs.result){
            for (int i = 0; i < l.size(); i++) {
                System.out.print(l.get(i));
            }
            System.out.println();
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSum(candidates,target,0);
    }
    /**
     * 思路：回溯算法，
     * 选择列表：每次可以选择数组中所有元素，每次选择元素时，会新增sum值
     * 递归结束条件：sum>target，结束递归；sum==target，记录当前路径到结果列表，结束递归；
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target, int start) {
        if(candidates==null||candidates.length==0){
            return result;
        }
        if(0>target){
            return result;
        }else if(0==target){
            result.add(new LinkedList<>(track));
        }
//        for (int i = 0; i <candidates.length; i++) {注意：这里不是从0开始，分析决策树发现，递归时，不能选择前面的元素，但是可以选择自己；
        for (int i = start; i <candidates.length; i++) {
            track.addLast(candidates[i]);
            combinationSum(candidates,target-candidates[i],i);
            track.removeLast();
        }
        return result;
    }
}
