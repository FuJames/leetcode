# coding:utf-8
# Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

# You may assume that the array is non-empty and the majority element always exist in the array.
class Solution(object):
    def majorityElement(self, nums):
        if (len(nums) == 1):
            return nums[0]
        nums.sort()
        counter = 1
        boundary = len(nums) / 2
        for i in range(0, len(nums) - 1):
            if nums[i + 1] == nums[i]:
                counter += 1
            else:
                counter = 1
            if counter > boundary:
                return nums[i]

# 做加1和减1的操作
class Solution2(object):
    def majorityElement(self, nums):
        counter = 0
        candidate = 0
        for num in nums:
            if counter == 0:
                counter = 1
                candidate = num
            else:
                if num == candidate:
                    counter += 1
                else:
                    counter -= 1
        return candidate


s = Solution2()
print s.majorityElement([1, 2, 2, 3, 2])
