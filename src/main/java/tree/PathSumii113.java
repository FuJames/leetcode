package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 */
public class PathSumii113 {
    List<List<Integer>> result=new LinkedList<>();
    LinkedList<Integer> track=new LinkedList<>();

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(7,null,null);
        TreeNode t2 = new TreeNode(2,null,null);
        TreeNode t3 = new TreeNode(11,t1,t2);
        TreeNode t5 = new TreeNode(5,null,null);
        TreeNode t6 = new TreeNode(1,null,null);
        TreeNode t4 = new TreeNode(4,t5,t6);
        TreeNode t7 = new TreeNode(13,null,null);
        TreeNode t8 = new TreeNode(4,t3,null);
        TreeNode t9 = new TreeNode(8,t7,t4);
        TreeNode t10 = new TreeNode(5,t8,t9);
        PathSumii113 p = new PathSumii113();
        System.out.println(p.pathSum(t10,22));
    }
    /**
     * 思路：回溯法，
     * 1、叶子节点&&sum==targetsum，路径有效
     * 2、每次选择时，左子树不为空&&左根节点+sum<=targetsum，递归左子树；右子树相同逻辑。
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return pathSum(root,targetSum,0);
    }

    private List<List<Integer>> pathSum(TreeNode root, int targetSum, int sum) {
        if(root==null){
            return result;
        }
        track.addLast(root.getVal());
        sum+=root.getVal();
        if(root.getLeft()==null&&root.getRight()==null){
            if(targetSum==sum){
                result.add(new LinkedList<>(track));
            }
//            return result;//错误点：不满足条件，不能直接返回，如果直接返回，当前root没有撤销选择
        }
//        if(root.getLeft()!=null&&(root.getLeft().getVal()+sum)<=targetSum){//错误点：包含负数的场景，不能加<=判断
        if(root.getLeft()!=null){
            pathSum(root.getLeft(),targetSum,sum);
        }
        if(root.getRight()!=null){
            pathSum(root.getRight(),targetSum,sum);
        }
        track.removeLast();
        sum-=root.getVal();
        return result;
    }
}
