package linklist;

import java.util.Stack;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 */
public class AddTwoNumbers445 {
    //思路一：链表反转后，从头遍历到尾部，按位相加，维护进位
    //思路二：使用栈来存储两个链表的节点，栈的数据是从低位到高位
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1=new Stack<>();
        Stack<ListNode> s2=new Stack<>();
        ListNode p=l1;
        while (p!=null){
            s1.push(p);
            p=p.getNext();
        }
        p=l2;
        while (p!=null){
            s2.push(p);
            p=p.getNext();
        }
        int c=0;
        ListNode head=null;
        while (true){
            int v1=0,v2=0;
            if(s1.isEmpty()&&s2.isEmpty()){
                //注意：当最终都弹完后，需要判断是否需要进位，新增节点（易错点）
                if(c==1){
                    ListNode n=new ListNode(1,head);
                    head=n;
                }
                break;
            }
            if(s1.isEmpty()){
                v2=s2.pop().getVal();
            }else if(s2.isEmpty()){
                v1=s1.pop().getVal();
            }else {//两个都不为空
                v1=s1.pop().getVal();
                v2=s2.pop().getVal();
            }
            int v=v1+v2+c;
            if(v>=10){
                v=v-10;
                c=1;
            }else {
                c=0;
            }
            //形成链表
            if(head==null){
                head=new ListNode(v,null);
            }else {
                ListNode n=new ListNode(v,head);
                head=n;
            }
        }
        return head;
    }
}
