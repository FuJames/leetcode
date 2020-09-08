package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author fuqianzhong
 * @date 2020/8/30
 * n叉树的前序遍历
 */
public class PreorderTraversal {
    public List<Integer> preorder(Node root) {
        //边界情况
        if(root==null){
            return Collections.emptyList();
        }

        List<Integer> list = new ArrayList<>();
        //递归前序遍历
        preorder(root,list);
        return list;
    }

    private void preorder(Node root, List<Integer> list) {
        if(root == null){
            return;
        }
        list.add(root.val);
        List<Node> children;
        if((children = root.children) != null && children.size()>0 ){
            for(Node node : children){
                preorder(node,list);
            }
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
