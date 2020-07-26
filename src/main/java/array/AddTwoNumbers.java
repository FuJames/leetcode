package main.java.array;


/**
 * @author fuqianzhong
 * @date 2020/7/25
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //边界判定
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        //新生成头结点，作为返回值
        ListNode head = null, p = null;
        //遍历l1和l2，l1和l2都不为空时，将l1、l2、进位相加
        int c = 0;
        while (l1 != null && l2 != null){
            int n = l1.val + l2.val + c;
            if(n >= 10){
                n -= 10;
                c = 1;
            }else {//出错点1：当无进位时，没有将c设置为0
                c = 0;
            }
            //新申请node？ 可以使用原来的node来做处理?
            if(p == null){
                head = p = new ListNode(n);
            }else {
                p.next = new ListNode(n);
                p = p.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        //如果l1不为空，说明l1比l2长度长，还需要将l1与进位相加，直到新产生的进位为0
        while (l1 != null){
            int n = l1.val + c;
            if(n >= 10){
                n -= 10;
                c = 1;
            }else {
                c = 0;
            }
            p.next = new ListNode(n);
            p = p.next;
            l1 = l1.next;
        }
        //如果l2不为空，说明l2比l1长度长，还需要将l2与进位相加，直到新产生的进位为0
        while (l2 != null){
            int n = l2.val + c;
            if(n >= 10){
                n -= 10;
                c = 1;
            }else {
                c = 0;
            }
            p.next = new ListNode(n);
            p = p.next;
            l2 = l2.next;
        }
        //错误点2：当所有加法都完成后，仍然有进位，没有考虑到
        if(c > 0){
            p.next = new ListNode(c);
        }
        //返回新节点
        return head;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        //边界判定
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        //新生成头结点，作为返回值
        ListNode head = null, p = null;
        //遍历l1和l2，l1和l2有1个不为空时，则对l1、l2、进位值做加法
        int c = 0;
        while (l1 != null || l2 != null){
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int n = l1Val + l2Val + c;
            if(n >= 10){
                n -= 10;
                c = 1;
            }else {//出错点1：当无进位时，没有将c设置为0
                c = 0;
            }
            if(p == null){
                head = p = new ListNode(n);
            }else {
                p.next = new ListNode(n);
                p = p.next;
            }
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }

        //错误点2：当所有加法都完成后，仍然有进位，没有考虑到
        if(c > 0){
            p.next = new ListNode(c);
        }
        //返回新节点
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
