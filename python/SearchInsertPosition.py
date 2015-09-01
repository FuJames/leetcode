# Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

class Solution(object):
	def searchInsert(self, nums, target):
		low = 0
		high = len(nums)-1
		while(low <= high):
			middle = (low + high) / 2
			if(nums[middle] == target):
				return middle
			elif(nums[middle] > target):
				high = middle - 1
			else:
				low = middle + 1
		if(low > len(nums)):
			return len(nums)
		if(high < 0):
			return 0
		return low

s = Solution()
print s.searchInsert([1,3,5,6],0)
