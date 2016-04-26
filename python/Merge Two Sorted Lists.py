# coding:utf8
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

# 非递归解法，交换指针法！
class Solution(object):
    def mergeTwoLists(self, l1, l2):
        if l1 is None:
            return l2
        if l2 is None:
            return l1

        head = l1
        p = l1
        q = l2
        if l1.val > l2.val:
            head = l2
            p = l2
            q = l1

        while p.next is not None:
            while p.next is not None and p.next.val <= q.val:
                p = p.next
            if p.next is not None:
                helper = p.next
                p.next = q
                p = q
                q = helper
        p.next = q
        return head

# ---------------------------------------------------------------------------
# 递归解法

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        if l1 is None:
            return l2
        if l2 is None:
            return l1

        head = None
        if l1.val < l2.val:
            head = l1
            head.next = self.mergeTwoLists(l1.next, l2)

        else:
            head = l2
            head.next = self.mergeTwoLists(l2.next, l1)

        return head

# 有两个名称一样的class，默认取最后一个
s = Solution()
a = ListNode(1)
b = ListNode(3)
a.next = b

c = ListNode(2)


print s.mergeTwoLists(a,c).val