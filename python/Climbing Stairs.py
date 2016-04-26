# Fibonacci sequence
class Solution(object):
    def climbStairs(self, n):
        if n == 1 or n == 2:
            return n
        f1 = 1
        f2 = 2
        for i in range(3, n+1):
            result = f1 + f2
            f1 = f2
            f2 = result
        return result


s = Solution()
print s.climbStairs(4)