package linklist;

/**
 * 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 思路：3指针法
 */
public class ReverseLinklist {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5,null);
        ListNode l2 = new ListNode(4,l1);
        ListNode l3 = new ListNode(3,l2);
        ListNode l4 = new ListNode(2,l3);
        ListNode head = new ListNode(1,l4);
        ListNode r = reverseList2(head);
        while (r!=null){
            System.out.println(r.getVal());
            r=r.getNext();
        }
    }

    /**
     * 3指针法，
     * 指针一：指向前节点
     * 指针二：指向当前节点
     * 指针三：指向后续节点
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.getNext() == null){
            return head;
        }
        ListNode p=null,c=head,n;
        while (c!=null){
            n = c.getNext();
            c.setNext(p);
            p=c;
            c=n;
        }
        return p;
    }
    /**
     * 递归法：
     */
    public static ListNode reverseList2(ListNode head) {
        if(head == null || head.getNext() == null){
            return head;
        }
        ListNode h = reverseList2(head.getNext());//1->2->3->4,此时head->1,n->2,h->4；1 4->3->2，需要把n.next=head,head->next=null
        head.getNext().setNext(head);
        head.setNext(null);
        return h;
    }
}
