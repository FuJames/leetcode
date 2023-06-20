package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据前序和后序遍历构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * */
public class ConstructBinaryTree105 {
    public static void main(String[] args) {

        ConstructBinaryTree105 c=new ConstructBinaryTree105();
        TreeNode r=c.buildTree(new int[]{1,2,4,5,3,6,7},new int[]{4,2,5,1,6,3,7});
        System.out.println(r);
    }
    /**
     * 思路：前序遍历：根->左->右，中序遍历：左->根->右
     * 1、preorder：第一个元素是根节点
     * 2、inorder：找到根节点在inorder中的位置root，左边是左子树，右边是右子树
     * 3、递归：root.left=递归(左子树前序遍历,inorder左子树中序遍历)，root.right=递归(右子树前序遍历,inorder右子树中序遍历)
     * 4、递归中的遍历序列如何确定？？ 中序遍历以根为界，左边是左子树，右边是右子树，可以确定左右子树的长度，在前序遍历序列中，通过左、右子树的长度来划出来子树。
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> preorderMap=new HashMap();
        Map<Integer,Integer> inorderMap=new HashMap();
        for (int j = 0; j <inorder.length; j++) {
            inorderMap.put(inorder[j],j);
        }
        return buildTree(0,preorder.length-1,preorder,0,inorder.length-1,inorder,inorderMap);
    }

    private TreeNode buildTree(int preStart, int preEnd, int[] preorder, int inStart, int inEnd, int[] inorder, Map<Integer, Integer> inorderMap) {
        if(preStart>preEnd||inStart>inEnd||preEnd>=preorder.length||inEnd>=inorder.length){
            return null;
        }
        int rootVal=preorder[preStart];
        int rootIndex=inorderMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        //核心算法：确定左子树和右子树区间，确定递归范围，左子树长度：rootIndex-1-inStart+1=rootIndex-inStart,右子树长度：inLength-1-rootIndex-1+1=inLength-rootIndex-1
        root.setLeft(buildTree(preStart+1,preStart+rootIndex-inStart,preorder,inStart,rootIndex-1,inorder,inorderMap));
        root.setRight(buildTree(preStart+rootIndex-inStart+1,preEnd,preorder,rootIndex+1,inEnd,inorder,inorderMap));
        return root;
    }
}
