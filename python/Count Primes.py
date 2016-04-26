# coding:utf8
# 最小的质数是2
# 给定n，找出小于n的所有质数
import math
# 下面的算法，在输入为499979超过时间限制
# class Solution(object):
#     def countPrimes(self, n):
#         if n <= 1:
#             return 0
#         count = 0
#         for i in range(2, n):
#             if self.is_prime(i):
#                 count += 1
#         return count
#
#     def is_prime(self,n):
#         if n <= 1:
#             return False
#         i = 2
#         while i * i <= n:
#             print i
#             if n % i == 0:
#                 return False
#             i += 1
#         return True

# 埃拉托色尼 筛选法
#
class Solution (object):
    def countPrimes(self, n):
        if n <= 1:
            return 0
        isPrime = [True] * n

        i = 2
        while i*i < n:
            if not isPrime[i]:
                i += 1
                continue
            for j in range(i*i, n, i):
                isPrime[j] = False
            i += 1
        count = 0
        for k in range(2, n):
            if isPrime[k]:
                count += 1
        return count

s= Solution()
print s.countPrimes(100)