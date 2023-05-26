package linklist;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class MergeTwoSortedLists21 {
    //思路：递归法，寻找递归框架。
    //建模：r1和r2指向两个链表的根节点，如果r1<=r2,r2合并到r1后面,r2.next=递归结果，r1为根节点，否则r1合并到r2后面，r2为根节点,
    // r1.next=递归结果
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode head=list1,l1Next=list1.getNext(),l2Next=list2.getNext();
        if(list2.getVal()<list1.getVal()){
            head=list2;
            list2.setNext(mergeTwoLists(list1,l2Next));//如果l2<l1，则递归(l1,l2.next)
        }else {
            list1.setNext(mergeTwoLists(l1Next,list2));
        }
//        head.getNext().setNext(mergeTwoLists(l1Next,l2Next));//错误点：不是按照顺序合并，合并之后需要有序 ！！！
        return head;
    }
}
