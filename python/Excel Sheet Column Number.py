#coding:utf-8
#使用ord函数将字母转化成ASCII码对应的数字
#**，是乘方运算
class Solution(object):
    def titleToNumber(self, s):
		cursor = len(s) - 1
		base = 65
		sum = 0
		for letter in s:
			sum += 26**cursor*(ord(letter) - base + 1)
			cursor -= 1
		return sum

s=Solution()
print s.titleToNumber('A') 