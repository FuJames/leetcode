package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fuqianzhong
 * @date 2020/9/8
 * /**
 * Print a given matrix in couter-clock spiral form
 *
 * Example I:
 * Input:  1    2   3   4
 *         5    6   7   8
 *         9   10  11  12
 *         13  14  15  16
 *
 * Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 *
 * Example II:
 * Input:  1   2   3   4  5   6
 *         7   8   9  10  11  12
 *         13  14  15 16  17  18
 *
 * Output: 1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
 *
 */
public class Tester {
    public static void main(String[] args) {
        //head1=1,3,5,7,9;head2=2,4,6,8,10;head3=3,5,8,9,10
        Node head14=new Node(9,null);
        Node head13=new Node(7,head14);
        Node head12=new Node(5,head13);
        Node head11=new Node(3,head12);
        Node head1=new Node(1,head11);

        Node head24=new Node(10,null);
        Node head23=new Node(8,head24);
        Node head22=new Node(6,head23);
        Node head21=new Node(4,head22);
        Node head2=new Node(2,head21);

        Node head34=new Node(10,null);
        Node head33=new Node(9,head34);
        Node head32=new Node(8,head33);
        Node head31=new Node(5,head32);
        Node head3=new Node(3,head31);

        Node sortedList[]=new Node[]{head1,head2,head3};
        Node head=mergeSortedList(sortedList);
        Node p = head;
        while (p!=null){
            System.out.println(p.val);
            p=p.next;
        }
        System.out.println(head);
    }
    public static Node mergeSortedList(Node sortedList[]){
        if(sortedList==null){
            return null;
        }
        if(sortedList.length==1){
            return sortedList[0];
        }
        Node min=null;
        int minVal = Integer.MAX_VALUE;
        //查找值最小的节点，作为返回的头结点
        for(Node node : sortedList){
            if(node==null){
                continue;
            }
            if(node.val<minVal){
                minVal = node.val;
                min = node;
            }
        }
        //构造新的数组，除去min，包括min.next
        //为何长度为length-1的时候，会超长呢？？
//        Node temp = new Node[sortedList.length-1];
        List<Node> list = new ArrayList<>();
        for (Node node : sortedList){
            if(node!=min){
                list.add(node);
            }else {
                if(node.next!=null) {
                    list.add(node.next);
                }
            }
        }
        //递归merge剩余的数组
        Node[] temp = new Node[list.size()];
        list.toArray(temp);
        Node next = mergeSortedList(temp);
        //将min.next设置为剩余数组的头结点
        min.next = next;
        return min;
    }
}
class Node{
    int val;
    Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}