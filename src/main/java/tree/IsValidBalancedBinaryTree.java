package tree;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class IsValidBalancedBinaryTree {
    /**
     * 递归法，
     * 1、当前根节点是不是平衡树，如果是看左子树和右子树是不是平衡二叉树
     * @param root
     * @return
    */
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int hl=height(root.getLeft());
        int rl=height(root.getRight());
        if(Math.abs(hl-rl)>1){
            return false;
        }
        return isBalanced(root.getLeft())&&isBalanced(root.getRight());
    }

    private int height(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(height(root.getLeft()),height(root.getRight()))+1;
    }

}
