# coding:utf8
# 从右向左，每次取出最大的放在在右边
class Solution(object):
    def merge(self, nums1, m, nums2, n):
        i, j, k = m-1, n-1, m+n-1
        while i >=0 and j >= 0:
            if nums2[j] > nums1[i]:
                nums1[k] = nums2[j]
                j -= 1
            else:
                nums1[k] = nums1[i]
                i -= 1
            k -= 1
        if i >= 0:
            for l in range(i, -1, -1):
                nums1[k] = nums1[l]
                k -= 1
        if j >= 0:
            for l in range(j,-1,-1):
                nums1[k] = nums2[l]
                k -= 1
