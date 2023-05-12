package linklist;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
public class PalindromeLinkedList234 {
    //简单思路：用map记录链表下表和对应值
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return false;
        }
        Map<Integer,Integer> m=new HashMap<>();
        ListNode p =head;
        int c=0,len=0;
        while (p!=null){
            m.put(c,p.getVal());
            c++;
            len++;
            p=p.getNext();
        }
        c=0;
        p=head;
        while (p!=null&&c<len/2){//[1][1,2][1,2,1][1,2,2,1]，只有1个字符串认定为true
            int t=len-1-c;
            if(p.getVal()!=m.get(t).intValue()){
                return false;
            }
            p=p.getNext();
            c++;
        }
        return true;
    }
}
