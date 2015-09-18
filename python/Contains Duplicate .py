class Solution(object):
    def containsDuplicate(self, nums):
		if(nums == None or len(nums) <= 1):
			return False
		map = {}
		for num in nums:
			if(map.get(num) == None):
				map[num] = 1
			else:
				return True
		return False

s = Solution()
print s.containsDuplicate([1,3,4,3,5])