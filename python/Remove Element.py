# coding:utf8

# 思路：
# 使用两个指针，分别从数组头部和尾部开始，头部指针向后遍历数组，如果找到与输入值相同的元素，停下；看尾部指针，
# 如果尾部指针所指元素与输入值相同，则向前移动尾部指针，直到它所指元素与输入值不同，调换头部指针与尾部指针所指元素。
# 直到头、尾指针重合结束遍历。

class Solution(object):
    def removeElement(self, nums, val):
        if not nums:
            return 0
        count = 0
        length = len(nums)

        rear = length - 1
        front = 0

        while front <= rear:
            if nums[front] == val:
                count += 1
                while nums[rear] == val and rear > front:
                    count += 1
                    rear -= 1
                if rear > front:
                    helper = nums[front]
                    nums[front] = nums[rear]
                    nums[rear] = helper
                    front += 1
                    rear -= 1
                else:
                    break
            else:
                front += 1

        return length - count