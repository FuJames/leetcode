#coding:utf8
# 题目：给定两个字符串s和t，判断它们是否是同构的。
# ps:所谓同构就是说有相同的结构，比如：asfsa 和 12321 。可以看作是一种映射关系，在这组字符串中，a对应的1，s对应的2，f对应的3，
# 并且asfsa中不能出现不同的字符映射到12321中的同一个字符的情况。
# 思路：
# 同时遍历两个字符串，用hash表记录source到target和target到source的映射关系，如果在遍历过程中，出现映射关系错误的情况，直接抛出错误。
class Solution(object):
    def isIsomorphic(self, s, t):
        if s is None or t is None or len(s) != len(t):
            return False

        sourceMap, targetMap = {}, {}

        for index in range(len(s)):
            source, target = sourceMap.get(t[index]), targetMap.get(s[index])

            if source is None and target is None:
                sourceMap[t[index]], targetMap[s[index]] = s[index], t[index]
            elif source != s[index] or target != t[index]:
                return False

        return True
