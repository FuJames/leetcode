import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 输入：一颗树的根节点
 * 输出：树的层序遍历
 */
public class cengxubianli {
    private static class Node{
        int v;
        Node l;
        Node r;

    }

    public static void main(String[] args) {
        /**
         * 压入元素(添加)：add()、offer()
         * 相同：未超出容量，从队尾压入元素，返回压入的那个元素。
         * 区别：在超出容量时，add()方法会对抛出异常，offer()返回false
         *
         * 弹出元素(删除)：remove()、poll()
         * 相同：容量大于0的时候，删除并返回队头被删除的那个元素。
         * 区别：在容量为0的时候，remove()会抛出异常，poll()返回false
         *
         * 获取队头元素(不删除)：element()、peek()
         * 相同：容量大于0的时候，都返回队头元素。但是不删除。
         * 区别：容量为0的时候，element()会抛出异常，peek()返回null。
         */
        //层序遍历的fifo 队列，记录待遍历列表，入队offer，出队poll
        Queue<Node> q = new LinkedList<>();
        //记录已遍历的路径
        List<Integer> r = new ArrayList<>();

        //根节点
        Node n = new Node();
        Node l = new Node();
        Node r1 = new Node();
        n.v = 1;
        l.v = 2;
        r1.v = 3;
        n.l = l;
        n.r = r1;
        cxbl(n,q,r);
        System.out.println(r);
    }

    private static void cxbl(Node n, Queue<Node> q, List<Integer> r) {
        while (n != null){
            q.offer(n.l);
            q.offer(n.r);
            r.add(n.v);
            n = q.poll();
        }
    }
}
