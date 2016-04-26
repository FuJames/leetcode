# coding:utf8

# 求最大公约数

# 欧几里德定理：
# 定理： gcd(a, b) = gcd(b, a mod b)
# 证明：
#   a可以表示成a = kb + r, 则r = a mod b
#   假设d是a, b的一个公约数， 则有  d|a, d|b, 而r = a - kb, 因此d|r。
#   因此，d是(b, a mod b)的公约数。
#   加上d是(b，a mod b)的公约数，则d|b, d|r, 但是a = kb + r,因此d也是(a, b)的公约数。
#   因此，(a, b) 和(a, a mod b)的公约数是一样的，其最大公约数也必然相等，得证。

class Solution(object):
    def gcd(self, a, b):
        if b == 0:
            return a
        return self.gcd(b, a % b)


s = Solution()
print s.gcd(2, 5)
print s.gcd(2, 6)
print s.gcd(4, 10)
