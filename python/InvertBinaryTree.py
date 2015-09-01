# coding:utf-8
# Invert a binary tree.

# 倒转一棵二叉树，实际上就是对每棵子树的根节点的左右节点互换

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
	def invertTree(self, root):
		if(root == None):
			return None 
		temp = root.left
		root.left = root.right
		root.right = temp
		self.invertTree(root.left)
		self.invertTree(root.right)
		return root

