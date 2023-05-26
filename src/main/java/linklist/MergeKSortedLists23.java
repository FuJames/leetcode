package linklist;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists23 {
    /**
     * 思路：参考MergeTwoSortedLists21，由合并2个链表转变为合并k个，使用数组来存储每个链表当前的指针，寻找值最小的当前指针最为根，递归下去。
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null){
            return null;
        }
        if(lists.length==1){
            return lists[0];
        }
        int min=-1,minVal=Integer.MAX_VALUE;
        ListNode head=null;
        //在curList寻找min指针对应的index
        for (int i = 0; i < lists.length; i++) {
            ListNode r = lists[i];
            if(r!=null){
                if(r.getVal()<=minVal){
                    min=i;
                    minVal=r.getVal();
                }
            }
        }
        if(min==-1){//递归完成
            return head;
        }
        head=lists[min];
        lists[min]=head.getNext();
        head.setNext(mergeKLists(lists));
        return head;
    }
}
