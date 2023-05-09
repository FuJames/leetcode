package linklist;

/**
 * 判断链表是否存在环
 */
public class CircleList {
    public static void main(String[] args) {
        ListNode l3 = new ListNode(5,null);
        ListNode l2 = new ListNode(8,l3);
        ListNode l1 = new ListNode(7,l2);
        ListNode l4 = new ListNode(2,l3);
        l3.setNext(l1);
        CircleList circleList = new CircleList();
        System.out.println(circleList.hasCircle(l4));
        System.out.println(circleList.circleNode(l4).getVal());

    }
    //判断链表是否存在环，快、慢指针法，如果快指针到链表尾部则无环，快慢指针相遇则有环
    //快指针与慢指针之间差N步。此时继续往后走，慢指针前进一步，快指针前进两步，两者之间相差(N+1-2)-> N-1步；
    //相差1步，快慢指针移动一次正好相遇
    //相差2不，移动1次相差1步
    public boolean hasCircle(ListNode root){
        if(root == null || root.getNext() == null){
            return false;
        }
        ListNode f,s;
        f=s=root;
        while (f!=null&&f.getNext()!=null){
            f=f.getNext().getNext();
            s=s.getNext();
            if(s==f){
                return true;
            }
        }
        return false;
    }

    //已知链表有环，判断环的起点
    //定义a为链表头结点，b为环起点，c为快慢指针首次相遇节点，则有ab=cb，从a和c分别向前走，相遇节点则为b环的起点
    public ListNode circleNode(ListNode root){
        if(root==null||root.getNext()==null){
            return null;
        }
        ListNode f,s;
        f=s=root;
        while (f!=null&&f.getNext()!=null){
            f=f.getNext().getNext();
            s=s.getNext();
            if(s==f){//找到c节点
                break;
            }
        }
        if(f==null||f.getNext()==null){//链表无环
            return null;
        }
        s=root;
        while (s!=f){
            s=s.getNext();
            f=f.getNext();
        }
        return s;
    }

}
