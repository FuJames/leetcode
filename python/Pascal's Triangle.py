# coding:utf8
# 定义：
# 每个数字等于上一行的左右两个数字之和。可用此性质写出整个杨辉三角。
#
# [
#      [1],
#     [1,1],
#    [1,2,1],
#   [1,3,3,1],
#  [1,4,6,4,1]
# ]

class Solution(object):
    def generate(self, numRows):
        if numRows == 0:
            return []
        result = []
        for size in range(numRows):
            level = size + 1
            tmpList = [1] * level
            if (size - 1) >= 0:
                helper = result[size - 1]
                for i in range(1, level - 1):
                    tmpList[i] = helper[i - 1] + helper[i]
            result.append(tmpList)
        return result

