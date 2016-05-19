# coding:utf8
# Given an index k, return the kth row of the Pascal's triangle.

# For example, given k = 3,
# Return [1,3,3,1].
#
# Note:
# Could you optimize your algorithm to use only O(k) extra space?


class Solution(object):
    def getRow(self, rowIndex):
        if rowIndex < 0:
            return []
        a = [0] * (rowIndex+1)
        b = [0] * (rowIndex + 1)
        a[0] = 1
        b[0] = 1
        for i in range(1,rowIndex+1):
            for j in range(1,i+1):
                a[j] = b[j-1] + b[j]
            b = a[:]
        return a

