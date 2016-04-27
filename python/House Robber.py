# coding:utf8

# 动态规划(Dynamic Programming)
# max[i]表示到第i个房间的最大金额
# max[i] = max{max[i-2] + num[i], max[i-1]}
class Solution(object):
    def rob(self, nums):
        if nums is None or len(nums) == 0:
            return 0
        m = 0
        n = nums[0]

        for i in  range(1, len(nums)):
            maxV = max(m + nums[i], n)
            m = n
            n = maxV

        return maxV

s = Solution()
print s.rob([1, 2, 3])

