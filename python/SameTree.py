# Given two binary trees, write a function to check if they are equal or not.

# Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSameTree(self, p, q):
    	if(p == None and q != None):
    		return False
    	elif(p != None and q == None):
    		return False
    	elif(p == None and q == None):
    		return True
    	else:
    		if(p.val != q.val):
    			return False
    		left = self.isSameTree(p.left,q.left)
    		if(left == True):
    			return self.isSameTree(p.right,q.right)
    		return False
        

s = Solution()
print s.isSameTree(None,None)