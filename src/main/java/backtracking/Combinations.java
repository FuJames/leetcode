package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 示例 1：
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combinations {
    LinkedList<Integer> track = new LinkedList<>();
    LinkedList<List<Integer>> result = new LinkedList<>();

    public static void main(String[] args) {
        Combinations c= new Combinations();
        c.combine(4,2);
        System.out.println();
        for (List<Integer> l : c.result){
            for (int i = 0; i < l.size(); i++) {
                System.out.print(l.get(i));
            }
            System.out.println();
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        return combine(n,1,k);
    }
    public List<List<Integer>> combine(int n, int start, int k) {
        if(k==0){//没得选的时候，记录当前路径至结果列表
            result.addLast(new LinkedList<>(track));
            return result;
        }
        for (int i = start; i <= n ; i++) {//注意：i从1开始
            track.addLast(i);
            combine(n,i+1,k-1);
            track.removeLast();
        }
        return result;
    }
}
