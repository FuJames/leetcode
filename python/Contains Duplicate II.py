# coding:utf8
# Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
#
# Subscribe to see which companies asked this question
# O(n)，用hashmap保存数字最近一次出现的位置
class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        if not nums or len(nums) <= 1:
            return False

        map = {}

        for i in range(len(nums)):
            helper = nums[i]
            j = map.get(helper)
            if j is None:
                map[helper] = i
            else:
                if (i - j) <= k:
                    return True
                map[helper] = i

        return False

s = Solution()
s.containsNearbyDuplicate([-1,-1], 1)