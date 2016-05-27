# coding:utf8
# Given a linked list, remove the nth node from the end of list and return its head.

# For example,
#
#    Given linked list: 1->2->3->4->5, and n = 2.
#
#    After removing the second node from the end, the linked list becomes 1->2->3->5.
# Note:
# Given n will always be valid.
# Try to do this in one pass.

# 思路：删除末尾处的第n个节点！！！！！
# 双指针思想，p走了n步之后，q开始走，p走到末尾时，q即为删除的节点；只需要遍历一遍即可！


class Solution(object):
    def removeNthFromEnd(self, head, n):
        if head is None or n == 0:
            return head

        p, q = head, head

        while n > 0 and p is not None: # 注意临界情况：p如果走到头的话，相当于删除头结点。
            p = p.next
            n -= 1

        if p is None:
            head = head.next
            return head

        while p.next is not None:
            p = p.next
            q = q.next

        q.next = q.next.next

        return head