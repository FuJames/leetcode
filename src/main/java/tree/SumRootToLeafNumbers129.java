package tree;

import java.util.List;

/**
 * Input: root = [1,2,3]
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 */
public class SumRootToLeafNumbers129 {
    /**
     * 思路：找到所有根路径，遍历根路径列表，求和即可，不重复写了。
     * 求所有根路径，参考BinaryTreePaths257
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        BinaryTreePaths257 binaryTreePaths257 = new BinaryTreePaths257();
        List<String> list = binaryTreePaths257.binaryTreePaths(root);
        return 0;
    }
}
