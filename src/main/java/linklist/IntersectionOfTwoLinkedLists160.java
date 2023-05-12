package linklist;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */
public class IntersectionOfTwoLinkedLists160 {
    //思路一：简单思路，遍历链表A，记录节点信息到hashmap，遍历链表B，看B中有没有与A一样的节点
    //思路二：数学思路，
    //假设链表 A 的节点数为 a，链表 B 的节点数为 b，两链表的公共尾部节点数为 c ，第一个公共节点为 c1。
    //让指针 PA 和 pB 分别指向链表 A 和链表 B 的头结点，之后两个指针分别以步幅为 1 的速度向链表的尾部遍历。
    //当指针 pA 遍历到链表 A 的尾节点时，此时指针 pA 走了 a 个节点，将指针 pA 指向链表 B 的头部，继续向后遍历，直至走到 c1，此时指针 PA 总共走了 a + ( b - c ) 步。
    //当指针 pB 遍历到链表 B 的尾节点时，此时指针 pB 走了 b 个节点，将指针 pB 指向链表 A 的头部，继续向后遍历，直至走到 c1，此时指针 PB 总共走了 b + ( a - c ) 步。
    //根据数学知识，a + ( b - c ) = b + ( a - c )   ，
    //如果 c > 0，表明两链表有公共尾部， c1 存在，两两链表同时到达 c1；如果 c = 0，表明两链表没有公共尾部，指针 PA 和 pB 都指向 NULL。
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        Map<ListNode,Boolean> m = new HashMap<>();
        ListNode p = headA;
        while (p!=null){
            m.put(p,true);
            p=p.getNext();
        }
        p=headB;
        while (p!=null){
            if(m.get(p)!=null){
                return p;
            }
            p=p.getNext();
        }
        return null;
    }
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode p=headA,q=headB;
        while (p!=q){
            p=p==null?headB:p.getNext();
            q=q==null?headA:q.getNext();
        }
        return p;
    }
}
