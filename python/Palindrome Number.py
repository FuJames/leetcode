# coding:utf8

# 回文数：
# 正反相同的整数
# 根据输入，计算反过来的整数，比较是否相等
class Solution(object):
    def isPalindrome(self, x):
        if x < 0:
            return False

        num = 0
        helper = x
        while helper > 0:
            num *= 10
            num += helper % 10
            helper /= 10
        return num == x

s = Solution()
print s.isPalindrome(1)