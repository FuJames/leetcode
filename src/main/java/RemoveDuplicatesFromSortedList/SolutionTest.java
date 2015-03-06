package RemoveDuplicatesFromSortedList;

import junit.framework.TestCase;

/**
 * Author: qianzhong.fu
 * Date: 2015/3/4
 * Time: 10:34
 */
public class SolutionTest extends TestCase {
    Solution solution = new Solution();
    public void testNull(){
        solution.deleteDuplicates(null);
    }
    public void testOneNode(){
        ListNode head = new ListNode(1);
        solution.deleteDuplicates(head);
        printNodes(head);
    }
    public void testTwoNodes(){
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(1);
        head.next = head1;
        solution.deleteDuplicates(head);
        printNodes(head);
    }
    public void testMultipleNodes(){
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(2);
        ListNode head4 = new ListNode(3);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        solution.deleteDuplicates(head);
        printNodes(head);
    }
    public void testThreeDifferentNodes(){
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        head.next = head1;
        head1.next = head2;
        solution.deleteDuplicates(head);
        printNodes(head);
    }

    public void printNodes(ListNode head){
        if(head == null)
            return ;
        ListNode cur = head;
        while(cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

}
