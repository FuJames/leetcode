package linklist;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 */
public class SortList148 {
    public static void main(String[] args) {
        ListNode h = new ListNode(4,null);
        ListNode l1 = new ListNode(2,null);
        ListNode l2 = new ListNode(1,null);
        ListNode l3 = new ListNode(3,null);
        h.setNext(l1);
        l1.setNext(l2);
        l2.setNext(l3);
        SortList148 s=new SortList148();
        s.sortList(h);
    }
    /**
     * 思路：
     * 1、递归法，插入排序思想，每次选择最小值的指针，作为根节点，需要把最小指针删除掉，继续递归 N方的时间复杂度
     * 2、递归法：归并排序，每次合并两个有序链表，又回到合并两个有序链表去了。 Lgn时间复杂度
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if(head==null||head.getNext()==null){
            return head;
        }
        //寻找中间节点，快慢指针法
        ListNode middle = findMiddle(head);
        //将链表从中间断开
        ListNode right = middle.getNext();
        middle.setNext(null);
        //两个链表分别排序
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(right);
        //合并两个有序链表
        return mergeTwoSortedList(l1,l2);
    }

    private ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode head;
        if(l1.getVal()< l2.getVal()){
            head=l1;
            head.setNext(mergeTwoSortedList(l1.getNext(),l2));
        }else {
            head=l2;
            head.setNext(mergeTwoSortedList(l1,l2.getNext()));
        }
        return head;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow=head,fast=head;
        while (fast!=null&&fast.getNext()!=null&&fast.getNext().getNext()!=null){//错误点：寻找slow，在纸上演练下！！
            fast=fast.getNext().getNext();
            slow=slow.getNext();
        }
        return slow;
    }
}
