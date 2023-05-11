package linklist;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 注意：是所有重复的数字。
 */
public class RemoveDuplicatesFromSortedList {
    //思路：递归法，
    //递归最重要的是框架，框架包括递归+结束条件，构造递归算法框架，分成以下两种情况（算法精髓），
    //1. 根节点与下一节点值相同，前半部分需要被排除掉，因此只要返回第一个不同元素为根节点的递归值即可。
    //2. 根节点与下一节点值不同，根节点.next=下一节点为根节点的递归值
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.getNext()==null){
            return head;
        }
        if(head.getVal()==head.getNext().getVal()){
            ListNode c=head.getNext();
            while (c!=null&&c.getVal()==head.getVal()){
                c=c.getNext();
            }
            return deleteDuplicates(c);
        }else {
            head.setNext(deleteDuplicates(head.getNext()));
            return head;
        }
    }
}
