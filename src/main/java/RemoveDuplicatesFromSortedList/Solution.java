package RemoveDuplicatesFromSortedList;

/**
 * Author: qianzhong.fu
 * Date: 2014/11/19
 * Time: 11:38
 *
 Given a sorted array, remove the duplicates in place such that each element appear only once
 and return the new length.
 Do not allocate extra space for another array, you must do this in place with constant memory.
 For example, Given input array A = [1,1,2],
 Your function should return length = 2, and A is now [1,2]

 需要考虑的问题：
 1.只有两个节点的情况。
 2.在遇到相同值时，当next到底的情况。
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode next = head.next;
        while(next != null) {
            if(cur.val == next.val){
                while (next != null && cur.val == next.val)
                    next = next.next;
                cur.next = next;
                cur = next;
                if(next != null)
                    next = next.next;
            }else{
                cur = next;
                next = next.next;
            }
        }
        return head;
    }
}
