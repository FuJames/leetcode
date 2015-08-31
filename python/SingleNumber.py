#coding:utf-8

#Given an array of integers, every element appears twice except for one. Find that single one.

#Note:
#Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

#o(n)的算法只能是线性扫描一遍，可能的想法是位运算。对于异或来说：

#1. 异或运算是可交换，即 a ^ b = b ^ a

#2. 0 ^ a = a

#那么如果对所有元素做异或运算，其结果为那个出现一次的元素，得解。

class Solution(object):
    def singleNumber(self, nums):
    	if (nums == None or len(nums) == 0) :
    		return 0
    	result = nums[0];
    	for index in range(1,len(nums)):
    		result = result ^ nums[index]
    	return result


# s = Solution()
# print s.singleNumber(None)
# list1 = []
# print s.singleNumber(list1)
# list2 = [1,1,2,2,4,4,5]
# print s.singleNumber(list2)
