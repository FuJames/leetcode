# coding:utf8
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
# 非递归法
class Solution(object):
    def levelOrderBottom(self, root):
        list = []
        if root is None:
            return list
        # queue = []
        # queue.append(root)
        queue = [root] # 以上两行可以用这一行初始化代替
        #while len(queue) > 0:
        while queue: # 代替len检查
            current_level = []
            helper = []
            for node in queue:
                # if node.left is not None:
                if node.left: # 代替is not None
                    current_level.append(node.left)
                if node.right:
                    current_level.append(node.right)
                helper.append(node)
            queue = current_level
            list.insert(0, helper)
        return list

# -----------------------------------
# leetcode 解法

class Solution:
    def levelOrderBottom(self, root):
        # write your code here
        self.results = []
        if not root:
            return self.results
        q = [root]
        while q:
            new_q = []
            self.results.append([n.val for n in q])
            for node in q:
                if node.left:
                    new_q.append(node.left)
                if node.right:
                    new_q.append(node.right)
            q = new_q
        return list(reversed(self.results))