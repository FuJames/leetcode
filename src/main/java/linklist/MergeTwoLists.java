package linklist;

/**
 * @author fuqianzhong
 * @date 2020/8/30
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 */
class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //边界判定
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        //找到数值较小的节点作为头节点返回，递归合并子链表
        ListNode head = l1;
        if(l1.val>l2.val){
            head = l2;
            head.next = mergeTwoLists(l1,l2.next);
        }else {
            head.next = mergeTwoLists(l1.next,l2);
        }
        return head;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

