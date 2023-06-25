package tree;

public class LowestCommonAncestorOfABinaryTree236 {
//    [3,5,1,6,2,0,8,null,null,7,4]
    public static void main(String[] args) {
        TreeNode r1=new TreeNode(3);
        TreeNode r2=new TreeNode(5);
        TreeNode r3=new TreeNode(1);
        r1.setLeft(r2);
        r1.setRight(r3);
        TreeNode r4=new TreeNode(6);
        TreeNode r5=new TreeNode(2);
        r2.setLeft(r4);
        r2.setRight(r5);
        TreeNode r6=new TreeNode(0);
        TreeNode r7=new TreeNode(8);
        r3.setLeft(r6);
        r3.setRight(r7);
        TreeNode r8=new TreeNode(7);
        TreeNode r9=new TreeNode(4);
        r5.setLeft(r8);
        r5.setRight(r9);
        System.out.println(new LowestCommonAncestorOfABinaryTree236().lowestCommonAncestor(r1,r2,r9));
    }
    /**
     * 思路：递归法，从下往上找，左子树或右子树中存在p和q时，根节点即为公共祖先，从下往上找考虑后序遍历思路，
     * 1、递归(左子树，p，q）和（右子树，p，q），如果找到了p或q，则返回，终止条件；
     * 2、如果左子树和右子树都有结果，说明p和q位于左右子树中，最终结果为root；否则，转3
     * 3、如果左子树有结果、右子树无结果，说明左子树中找到了p或q或公共祖先，则最终结果为左子树的结果，否则，转4
     * 4、如果右子树有结果、左子树无结果，说明右子树中找到了p或q或公共祖先，则最终结果为右子树的结果，否则转5
     * 5、左、右子树都没有结果，说明没有找到p和q，返回空，继续向上查找
     * @param root
     * @param p
     * @param q
     * @return
     * 3,5,1,6
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||p==root||q==root){//如果根节点是p或q，根节点就是公共祖先
            return root;
        }
        TreeNode l=null,r=null;
        if(root.getLeft()!=null){
            l=lowestCommonAncestor(root.getLeft(),p,q);
        }
        if(root.getRight()!=null){
            r=lowestCommonAncestor(root.getRight(),p,q);
        }
        if(l!=null&&r!=null){
            return root;
        } else if (l==null&&r==null) {
            return null;
        } else if (l!=null) {
            return l;
        }else {
            return r;
        }
    }
}
