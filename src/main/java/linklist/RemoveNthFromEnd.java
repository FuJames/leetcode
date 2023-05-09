package linklist;

/**
 * 19. 删除链表的倒数第 N 个结点
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {

    }

    /**
     * 思路：双指针法，p初始为head、q初始为空
     * 1. 第一个指针，从头开始到第K个结束，p先走n步，
     * 2. 第二个指针，从头开始到第一个指针结束停止，p.getNext()!=null，此时q指向被删除节点的前驱节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||n<=0){
            return head;
        }
        ListNode p=head,q=head;
        int i=0;
        while (i++<n&&p!=null){
            p=p.getNext();
        }
        if(p==null){//注意边界条件：当p为空时，需要删除头结点，可以纸上模拟下[1],1的场景。
            return head.getNext();
        }
        //注意：q需要指向被删除的前一个节点，所以需要判断p.getNext!=null，而不是p!=null；在纸上模拟演练下。
        while (p.getNext()!=null){
            p=p.getNext();
            q=q.getNext();
        }
        q.setNext(q.getNext().getNext());
        return head;
    }
}
