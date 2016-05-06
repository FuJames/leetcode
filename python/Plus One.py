class Solution(object):
    def plusOne(self, digits):
        if not digits:
            return digits
        carry = 1
        for i in range(len(digits) - 1, -1, -1):
            helper = digits[i] + carry
            if helper >= 10:
                digits[i] = helper - 10
                carry = 1
            else:
                digits[i] = helper
                carry = 0
        if carry >= 1:
            digits.insert(0, 1)
        return digits
s = Solution()
digits = s.plusOne([9])
print digits