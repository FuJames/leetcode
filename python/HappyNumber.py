# coding:utf8
# Write an algorithm to determine if a number is "happy".
#
# A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
#
# Example: 19 is a happy number
#
# 12 + 92 = 82
# 82 + 22 = 68
# 62 + 82 = 100
# 12 + 02 + 02 = 1
# 理解题意，写伪代码
import math

class Solution(object):
    def isHappy(self, n):
        if n < 1:
            return False
        list = [n]
        while True:
            sum = 0
            while n > 0:
                sum += int(math.pow(n % 10, 2))
                n /= 10
            if sum == 1:
                return True
            if sum in list: # 防止循环
                return False
            n = sum
            list.append(sum)

s = Solution()
print s.isHappy(8)
