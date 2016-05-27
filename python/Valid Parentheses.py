# coding:utf8

class Solution(object):
    def isValid(self, s):
        if not s or len(s) % 2 == 1:
            return False
        stack = []

        for c in s:
            if c != ")" and c != "]" and c != "}":
                stack.append(c)
            else:
                if len(stack) == 0:
                    return False
                top = stack.pop()
                if c == ")" and top != "(":
                    return False
                elif c == "]" and top != "[":
                    return False
                elif c == "}" and top != "{":
                    return False
        if len(stack) > 0:
            return False
        return True


s = Solution()
print s.isValid("((")

