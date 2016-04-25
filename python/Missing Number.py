# coding:utf-8
# Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

# For example,
# Given nums = [0, 1, 3] return 2.

# Note:
# Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

# 线性： 想到异或, 0 异或任何 数字 都是自己

# 1) XOR all the array elements, let the result of XOR be X1.
# 2) XOR all numbers from 1 to n, let XOR be X2.
# 3) XOR of X1 and X2 gives the missing number.

class Solution(object):
    def missingNumber(self, nums):
        if nums is None or len(nums) == 0:
            return None

        xor = reduce(lambda x, y: x ^ y, range(0, len(nums) + 1), 0)

        return reduce(lambda x, y: x ^ y, nums, xor)


s = Solution()
nums = [1]
print s.missingNumber(nums)
