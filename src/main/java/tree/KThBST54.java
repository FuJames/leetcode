package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 */
public class KThBST54 {
    List<Integer> result=new ArrayList<>();
    /**
     * 思路：后序遍历得到从大到小的序列，
     * 后序遍历：递归右节点->操作根节点->递归左节点
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        kthLargest(root);
        return result.get(k-1);
    }

    private void kthLargest(TreeNode root) {
        if(root==null){
            return ;
        }
        if(root.getRight()!=null){
//            result.add(root.getRight().getVal());
            kthLargest(root.getRight());
        }
        result.add(root.getVal());
        if(root.getLeft()!=null){
//            result.add(root.getLeft().getVal());
            kthLargest(root.getLeft());
        }
    }
}
