# coding:utf8

# 递归解题
# 首先获取左子树的高度，再获取右子树的高度，判断当前节点是否是balanced；如果是，继续判断其左子树和右子树

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def isBalanced(self, root):
        if root is None:
            return True

        leftHeight = self.getDepth(root.left)
        rightHeigth = self.getDepth(root.right)
        if abs(leftHeight - rightHeigth) > 1:
            return False
        return self.isBalanced(root.left) and self.isBalanced(root.right)
    def getDepth(self, root):
        if root is None:
            return 0
        return max(self.getDepth(root.left) , self.getDepth(root.right)) + 1