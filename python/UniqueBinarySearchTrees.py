#coding:utf-8
#关键在于numTrees(n) = numTrees(k,n-1-k)
#ut[n],表示n个元素时的bst个数
#通过枚举法发现规律
#bstRoot[k] = ut[0 ... k] * ut[n-k-1]，bstRoot[k]表示以k为根的bst个数
#k从1到n，对bstRoot[k],求和结果为ut[n]
class Solution(object):
	def numTrees(self, n):
		ut = {0:1,1:1} 
		sum = 0
		for i in range(2,n+1):
			ut[i] = 0
			for j in range(0,i):
				ut[i] += ut[j] * ut[i-j-1]
		return ut[n] 

s = Solution()
print s.numTrees(2)