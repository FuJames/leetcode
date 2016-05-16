# coding:utf8
# 分类：bit manipulation
# 4的幂次方的数对应的二进制有以下特性：
# 1.只有一个1，且在最高位
# 2.最高位是偶数位
class Solution(object):
    def isPowerOfFour(self, num):
        if num <= 0:
            return False
        helper = 0
        index = 0
        while num > 0:
            digit = num % 2
            if digit == 1:
                if index % 2 == 0:
                    if helper == 0:
                        helper += 1
                    else:
                        return False
                else:
                    return False
            num /= 2
            index += 1

        return True