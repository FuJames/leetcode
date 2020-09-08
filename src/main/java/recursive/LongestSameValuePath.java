package main.java.recursive;

/**
 * @author fuqianzhong
 * @date 2020/9/7
 *
 */
public class LongestSameValuePath {
    private static int result = 0;

    public int longestUnivaluePath(TreeNode root) {
        //如果root为空，返回0
        if(root==null){
            return 0;
        }
        //计算左、右子树最长路径值，如果左子树与根相同，则height(left)=longestUnivaluePath(root.left)+1，右子树同理
        TreeNode left,right;
        int hl=0,hr=0,ll=0,lr=0;
        if((left=root.left)!=null){
            hl=longestUnivaluePath(left);
            if(left.val == root.val){
                ll=hl+1;
            }
        }

        if((right=root.right)!=null){
            hr=longestUnivaluePath(right);
            if(right.val==root.val){
                lr=hr+1;
            }
        }
        result=Math.max(result,ll+lr);
        //返回max(height(left),height(right))
        return Math.max(hl,hr);
    }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
