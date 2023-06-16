package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：["1"]
 */
public class BinaryTreePaths257 {
    private LinkedList<String> result=new LinkedList<>();
    private LinkedList<Integer> track=new LinkedList<>();
    /**
     * 思路：回溯法，
     * 1、result
     * 2、tracklist：选择、撤销选择
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        binaryTreePaths2(root);
        return result;
    }

    private void binaryTreePaths2(TreeNode root) {
        if(root==null){
            return ;
        }
        track.addLast(root.getVal());//选择根节点
        if(root.getLeft()==null&&root.getRight()==null){
            StringBuilder s=new StringBuilder();
            for (int j = 0; j < track.size(); j++) {
                if(j!=(track.size())-1){
                    s.append(track.get(j)+"->");
                }else {
                    s.append(track.get(j));
                }
            }
        }
        binaryTreePaths2(root.getLeft());
        binaryTreePaths2(root.getRight());
        track.removeLast();
    }
}
