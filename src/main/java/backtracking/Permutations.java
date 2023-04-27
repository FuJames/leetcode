package backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 思路：构造决策树，
 *        1       2    3
 *       2 3     1 3   1  2
 *     3     2  3 1   2    1
 *  第一层，先选择1，再选择2，再选择3
 *  第二层，假设第一层选择2，可以再选择到1，如何能够选择到1 ？ 是否可以每次从第0位开始选，如果碰到跟2这位一致，则跳过；
 *  如何判定跟2一致，是否可以转化为路径列表.contains(2)；
 */
public class Permutations {
    LinkedList<Integer> track = new LinkedList<>();
    LinkedList<List<Integer>> result = new LinkedList<>();

    public static void main(String[] args) {
        Permutations p = new Permutations();
        p.permute(new int[]{1,2,3,4});
        for (List<Integer> l : p.result){
            for (int i = 0; i < l.size(); i++) {
                System.out.print(l.get(i));
            }
            System.out.println();
        }
    }
    public List<List<Integer>> permute(int[] nums){
        boolean used[] = new boolean[nums.length];
        return permute(nums,used);
    }

    public List<List<Integer>> permute(int[] nums,boolean used[]) {

        if(track.size() == nums.length){//精髓 ！！结束条件，专业的 ！
            result.addLast(new LinkedList<>(track));
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
//            if(track.contains(nums[i])){//可以用一个boolean数组记录i是否被选择过
//                continue;
//            }
            if(used[i]){
                continue;
            }
            used[i]=true;
            track.addLast(nums[i]);
            permute(nums,used);
            track.removeLast();
            used[i]=false;
        }
        return result;
    }
}
