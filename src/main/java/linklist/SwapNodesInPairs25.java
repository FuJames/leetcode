package linklist;

public class SwapNodesInPairs25 {
    //链表：两两交换节点
    //1,2,3,4 2,1,4,3
    //1,2,3 2,1,3
    //思路：递归法，
    //
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.getNext()==null){
            return head;
        }
        ListNode p=head.getNext(),q=p.getNext();
        p.setNext(head);
        head.setNext(swapPairs(q));
        return p;
    }
}
