package linklist;

/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 */
public class ReverseLinkList2 {
    private static ListNode nextNode;
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5, null);
        ListNode l2 = new ListNode(4, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(2, l3);
        ListNode head = new ListNode(5, null);
        ListNode r = reverseBetween(head, 1, 1);
        while (r != null) {
            System.out.println(r.getVal());
            r = r.getNext();
        }
    }

    //1->2->3->4->5 反转第2到第4位置 1 4->3->2 5 得到 1->4->3->2->5
    //思路：递归法
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        if (left <= 0 || right <= 0) {
            return null;
        }
        if (left >= right) {
            return head;
        }
        //找到第left-1个节点p，如果p!=null，p.next=反转后的链表头节点，如果p==null，不需要做p.next=xx
        //找到第right+1个节点q，如果q!=null，反转前的链表头节点.next=反转后的链表尾节点.next=q
        ListNode p = null, q = null, t = head;
        int i = 1;
        while (t != null && i <= right) {
            if (i == left - 1) {
                p = t;
            }
            if (i == right) {
                q = t.getNext();
                t.setNext(null);//先截断链表
            }
            t = t.getNext();
            i++;
        }
        //记录反转前的链表头结点
        ListNode oldHead = head;
        if (p != null) {
            oldHead = p.getNext();
        }
        ListNode newHead = reverse(oldHead);
        if (p != null) {
            p.setNext(newHead);
        }
        if (q != null) {
            oldHead.setNext(q);
        }
        if (p != null) {//如果不是从头开始反转，返回老链表头节点
            return head;
        } else {//从头开始反转，返回反转后的链表头节点
            return newHead;
        }
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode newHead = reverse(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }

    /**
     * 递归法：升级版
     * 如果left==1，反转前N个节点即可
     * 如果left>1，子序列reverseN(head->next,left-1,right-1)，直到left-1减少到为1为止，base case就变成了reverseN问题
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head,right);
        }
        head.setNext(reverseBetween2(head.getNext(),left-1,right-1));
        return head;
    }

    /**
     * 反转自head开始的第m个元素
     * 正常思路：先找到第N+1个节点，反转第1-N位置的链表，将第N+1个节点拼接到反转后的链表。
     * 升级思路：reverseN.next.next(reverseN-1);reverseN.next=第N+1个节点。
     * @param head
     * @param m
     * @return
     */
    public static ListNode reverseN(ListNode head,int m){
        if(m<=0){
            return head;
        }
        if(m==1){
            nextNode=head.getNext();//关键，这里是通过递归来给第N+1个节点赋值
            return head;
        }
        ListNode newHead = reverseN(head.getNext(),m-1);
        head.getNext().setNext(head);
        head.setNext(nextNode);
        return newHead;
    }

}
