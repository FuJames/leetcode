# coding:utf8
import math
# Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

# For example:

# Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

# Follow up:
# Could you do it without any loop/recursion in O(1) runtime?

# 输入一个整数，如何打印它每一位的数字？

# 123 = 1 * 100 + 2 * 10 + 3 * 1

# num = 123
# while num > 0:
#     print "digit is ", num % 10
#     num /= 10

# 非O(1)算法
# class Solution(object) :
#     def addDigits(self, num):
#         while num >= 10:
#             num = num / 10 + num % 10
#         return num
#余数定理：其中a,b,c都是自然数（0和正整数）
# 1.余数的加法定理
#    a与b的和除以c的余数，等于a,b分别除以c的余数之和，或这个和除以c的余数。
# 2.余数的乘法定理
#    a与b的乘积除以c的余数，等于a,b分别除以c的余数的积，或者这个积除以c所得的余数。
#From Wiki
#DR(n) = 1+(n-1)%9
# 寻找规律，
# 1 2 3 4 5 6 7 8 9
# 10 11 12 13 14 15 16 17 18
# 19 20 21 22 23 24 25 26 27
# 注意到了吗，就是一个矩阵，求元素所在列数
class Solution(object) :
    def addDigits(self, num):
    	if(num == 0):
    		return 0
        return 1+(num-1)%9

s = Solution()
print s.addDigits(0)
print s.addDigits(38)
print s.addDigits(225)