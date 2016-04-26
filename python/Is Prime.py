# coding:utf8
# 质数：能且只能整除1和自己的自然数,最小的质数是2

# 利用一个定理——如果一个数是合数，那么它的最小质因数肯定小于等于他的平方根。
# 合数是与质数相对应的自然数。一个大于1的自然数如果它不是合数，则它是质数。
import math
class Solution(object):
    def isPrime(self, n):
        if n <= 1:
            return False
        for i in range(2, int(math.sqrt(n)) + 1):
            if n % i == 0:
                return False
        return True


s = Solution()
print s.isPrime(5)
print s.isPrime(3)
print s.isPrime(10)
print s.isPrime(7)