class Solution(object):
    def minDepth(self, root):
        if not root:
            return 0

        left = self.minDepth(root.left)
        right = self.minDepth(root.right)
        if left == 0:
            return right + 1
        elif right == 0:
            return left + 1
        else:
            min = left
            if right < left:
                min = right
            return min + 1