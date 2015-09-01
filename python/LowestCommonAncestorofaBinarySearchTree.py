# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# Notice : Binary Search Tree
class Solution(object):
	def lowestCommonAncestor(self, root, p, q):
		if(root == p or root == q):
			return root
		min = p.val
		max = q.val
		if(p.val > q.val):
			min = q.val
			max = p.val
		if(root.val < min):
			return self.lowestCommonAncestor(root.right,p,q)
		if(root.val > max):
			return self.lowestCommonAncestor(root.left,p,q)
		if(min < root.val and root.val < max):
			return root