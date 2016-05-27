# coding:utf8

# Find the total area covered by two rectilinear rectangles in a 2D plane.
# Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
# 计算所有面积=总面积-相交面积
# A,B等输入请参考leetcode 原题
class Solution(object):
    def computeArea(self, A, B, C, D, E, F, G, H):
        total = (C - A) * (D - B) + (G - E) * (H - F)
        A1 = max(A, E)
        C1 = min(C, G)
        D1 = min(D, H)
        B1 = max(B, F)
        if C1 <= A1 or D1 <= B1:
            return total

        intersection = (A1 - C1) * (B1 - D1)

        return total - intersection

