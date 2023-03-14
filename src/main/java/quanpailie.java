import java.util.ArrayList;
import java.util.List;

/**
 * 回溯问题：回溯算法框架，就是对树或图做一次深度遍历，需要回到某个已经遍历过的节点重新做选择，
 * 需要一个list记录已走过的路径，
 * 需要一个list记录可选择的路径（可选列表可以实时计算而来，比如深度遍历），
 * 需要一个结束条件。
 * result = []
 * def backtrack(路径, 选择列表):
 *      if 满⾜结束条件:
 *          result.add(路径)
 *          return
 *      for 选择 in 选择列表:
 *          做选择（将选择加入到路径）
 *          backtrack(路径, 选择列表)
 *          撤销选择（将选择从路径删除）
 *
 */
public class quanpailie {
    //1,2,3,4
    public static void main(String[] args) {

        quanpailie q = new quanpailie();
        //结果列表
        List<List<Integer>> r = new ArrayList<>();
        //路径
        List<Integer> p = new ArrayList<>();
        //全排列n
        int n = 4;
        //可选择列表
        List<Integer> c = new ArrayList<>();
        for(int i = 1;i<=n;i++){
            c.add(i);
        }
        q.qpl(n,p,c,r);
        for(List<Integer> l : r){
            for(Integer i : l){
                System.out.print(i);
            }
            System.out.println();
        }

    }
    //回溯时，需要带上路劲列表，选择列表可实时计算
    public void qpl(int n, List<Integer> p, List<Integer> c, List<List<Integer>> r){
        //结束条件
        if(p.size() == n){
            //错误二：直接将p加到结果值里面，但是p在递归中会不断被改变值，需要创建一个新的list出来
//            r.add(p);
            r.add(new ArrayList(p));
            return;
        }

        //遍历选择列表，做选择、记录路径
        //错误一：遍历一个list，同时删除元素，触发java.util.ConcurrentModificationException异常
//        for(Integer i : c){
//            p.add(i);
//            c.remove(i);
//            qpl(n,p,c,r);
//            p.remove(i);
//            c.add(i);
//        }
        List<Integer> tmp = new ArrayList<>(c);
        for(Integer i : tmp){
            p.add(i);
            c.remove(i);
            qpl(n,p,c,r);
            p.remove(i);
            c.add(i);
        }
    }
}
