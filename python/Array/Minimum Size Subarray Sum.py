# coding:utf8
# 给定一个包含n个正整数的数组和一个正整数s，找出长度最短的子数组使得这个子数组中所有元素的和大于等于s，返回这个子数组的
# 长度。
# 方法：滑动窗口法，使用两根指针分别表示窗口的头和尾。
# 时间：O(n)
# 空间：O(1)
class Solution(object):
    def minSubArrayLen(self, s, nums):
        start = end = sum = 0
        size = len(nums)
        minLength = size + 1
        while end < size:
            while end < size and sum < s:# 移动右窗口，直到当前和大于等于s，或者遍历到尾部
                sum += nums[end]
                end += 1

            while sum >= s and start < end:# 移动左窗口，寻找最小子数组
                minLength = min(end - start, minLength)
                sum -= nums[start]
                start += 1
            

        return [0, minLength][minLength <= size] # 如果minLength没有更改过，则不存在满足条件的子数组，返回0；反则，返回minLength


