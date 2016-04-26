# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def swapPairs(self, head):
        if head is None or head.next is None:
            return head

        p = head.next
        q = p.next
        p.next = head
        head.next = self.swapPairs(q)
        return p