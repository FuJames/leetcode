# coding:utf8
# 解法1：先排序，然后从开头和结尾同时向中间查找，原理也比较简单。复杂度O(nlogn)
# 解法2：使用HashMap。把每个数都存入map中，任何再逐个遍历，查找是否有 target – nubmers[i]。 时间复杂度 O(n)

class Solution(object):
    def twoSum(self, nums, target):
        if not nums or len(nums) <= 1:
            return None

        map = {}

        for index in range(len(nums)):
            map[nums[index]] = index

        for i in range(len(nums)):
            j = map.get(target - nums[i])
            if j is not None and j != i:
                return [i, j]
        return []
