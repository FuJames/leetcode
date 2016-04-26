# coding:utf8
# Write a program to check whether a given number is an ugly number.
# Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
# Note that 1 is typically treated as an ugly number.
# 理解题意：
# 一个数字的因子指的是能够被这个数字整除的质数
# 因此，因子是本身不能再分解的数字
# 8是ugly number
# 因此，一个数如果是ugly number，就一定能整除2或3，或5，直到商为1
import math


class Solution(object):
    def isUgly(self, num):
        if num <= 0:
            return False
        if num == 1:
            return True

        while num % 2 == 0:
            num /= 2
        while num % 3 == 0:
            num /= 3
        while num % 5 == 0:
            num /= 5
        if num == 1:
            return True
        return False

s = Solution()
print s.isUgly(2)
print s.isUgly(4)
print s.isUgly(14)
