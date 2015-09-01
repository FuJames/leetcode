class Solution(object):
	def hammingWeight(self, n):
		count = 0
		while(n != 0):
			if(n%2 == 1):
				count = count + 1
			n /= 2
		return count

s = Solution()
print s.hammingWeight(2)
print s.hammingWeight(11)

