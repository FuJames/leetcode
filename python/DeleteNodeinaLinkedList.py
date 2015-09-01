#coding:utf-8
# Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

# Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
#只给定一个待删除的节点，通过删除下一个节点来实现
class Solution(object):
    def deleteNode(self, node):
    	if(node == None or node.next == None):
    		return
    	node.val = node.next.val
    	node.next = node.next.next


