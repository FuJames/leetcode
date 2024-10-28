package linklist;

/**
 * 19. 删除链表的倒数第 N 个结点
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {

    }
    //思路：双指针法,p,q初始化为head节点，
    //1. p指针先走n步停下
    //2. q指针从头开始走，q需要指向被删除节点的前一个节点，因此当p走到链表最后一个节点时停下，此时q为期望位置。
    //1,2,3,4,5 n=1 p->2,q->1;p->5(走3步)，q->4
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head==null||n<=0){
            return head;
        }
        ListNode p=head,q=head;
        int i=0;
        while (i<n&&p!=null){
            p=p.getNext();
            i++;
        }
        if(p==null){//p为空时，说明链表已经遍历完，i=链表长度
            if(i<n) {//n>i，说明待删除的元素不存在
                return head;
            }else {//n=i，说明需要删除"倒数第链表长度"个元素，即删除头结点
                return head.getNext();
            }//n<i，p不可能为空，因为i是链表长度，继续往下走即可。
        }
        while (p.getNext()!=null){//注意是p指向最后一个链表节点时停下
            p=p.getNext();
            q=q.getNext();
        }
        q.setNext(q.getNext().getNext());//不会有npe，因为p都还没有为null，q.next至少为p，q.next也不可能为null,
        return head;
//        if(q==head){//头结点删除特殊处理，错误：q即使指向head，也一定需要将q的下一个节点删除。因为此时q的含义是指向被删除节点的上一个节点
//            return head.getNext();
//        }else {
//            q.setNext(q.getNext().getNext());//npe？
//            return head;
//        }
    }
    /**
     * 思路：双指针法，p初始为head、q初始为空
     * 1. 第一个指针，从头开始到第K个结束，p先走n步，
     * 2. 第二个指针，从头开始到第一个指针结束停止，p.getNext()!=null，此时q指向被删除节点的前驱节点
     * 假设n必须在数组范围内
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
        //注意：q需要指向被删除的前一个节点，所 以需要判断p.getNext!=null，而不是p!=null；在纸上模拟演练下。
        while (p.getNext()!=null){
            p=p.getNext();
            q=q.getNext();
        }
        q.setNext(q.getNext().getNext());
        return head;
    }
}
