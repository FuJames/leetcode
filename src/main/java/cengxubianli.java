import java.util.*;

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
         offer：添加元素
         poll：获取元素
         */
        //层序遍历的fifo 队列，记录待遍历列表，入队offer，出队poll
        Queue<Node> q = new LinkedList<>();
        System.out.println(q.poll());
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());
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
