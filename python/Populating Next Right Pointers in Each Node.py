# coding:utf-8
# Definition for binary tree with next pointer.
class TreeLinkNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
        self.next = None


# 对于每一个节点，有:
# root.left.next = root.right,root.right.next = root.next.left
# 要求常量空间，因此不能用queue，考虑用一个局部变量
# 题目中假定二叉树为完全二叉树
class Solution(object):
    def connect(self, root):
        if root is None:
            return
        leftNode = root
        while leftNode.left is not None:
            levelCursor = leftNode
            while levelCursor is not None:
                levelCursor.left.next = levelCursor.right
                if levelCursor.next is not None:
                    levelCursor.right.next = levelCursor.next.left
                levelCursor = levelCursor.next
            leftNode = leftNode.left


s = Solution()
root = TreeLinkNode(1)
root.left = TreeLinkNode(2)
root.right = TreeLinkNode(3)

s.connect(root)
print root.left.next.val
