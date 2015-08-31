#coding:utf-8
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def maxDepth(self, root):
    	if(root == None):
    		return 0
    	leftHeight = self.maxDepth(root.left)
    	rightHeigh = self.maxDepth(root.right)
    	if(leftHeight > rightHeigh):
    		return leftHeight + 1
    	else:
    		return rightHeigh + 1
        
# root = TreeNode(1)
# node1 = TreeNode(2)
# node1.left = TreeNode(4)
# node1.right = TreeNode(4)
# root.left = node1
# s = Solution()
# print s.maxDepth(root)