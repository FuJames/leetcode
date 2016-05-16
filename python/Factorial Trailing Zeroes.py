# coding:utf8

# 对n!做质因数分解n!=2^x*3^y*5*z*...

# 显然0的个数等于min(x,z)，并且min(x,z)==z

# 实际上是求5的个数

class Solution(object):
    def trailingZeroes(self, n):
        if n < 5:
            return 0

        count = 0

        while n > 0:
            count += n/5
            n /= 5

        return count