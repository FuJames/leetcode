package tree;

/**
 * 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 思路：二叉树常规思路，递归。
 * 对于任意节点，其所有左子树都小于根节点，所有右子树大于根节点。
 * 我们不可能遍历左子树并寻找最小节点，需要增加max和min节点，
 *  当向左子树遍历时，max节点为root节点；当向右子树遍历时，min节点为root节点；min和max递归向下传递；初始状态下，min和max为空。
 */
public class IsValidBST {
    public static void main(String[] args) {
        TreeNode l1 = new TreeNode(1,null,null);
        TreeNode r1 = new TreeNode(3,null,null);
        TreeNode root = new TreeNode(2,l1,r1);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root,null,null);
    }
    public static boolean isValidBST(TreeNode root,TreeNode min,TreeNode max) {
        if(root == null){
            return true;
        }
        if(min != null && root.getVal() <= min.getVal()){
            return false;
        }
        if(max != null && root.getVal() >= max.getVal()){
            return false;
        }
        return isValidBST(root.getLeft(),min,root) && isValidBST(root.getRight(),root,max);
    }
}



