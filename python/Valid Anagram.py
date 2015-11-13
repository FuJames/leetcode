#coding:utf-8
# Given two strings s and t, write a function to determine if t is an anagram of s.

# For example,
# s = "anagram", t = "nagaram", return true.
# s = "rat", t = "car", return false.

# 字谜游戏，给定两个词，判断这两个词是否只有组成的字母顺序不一样。

class Solution(object):
	def isAnagram(self, s, t):
		if(s == None or t == None):
			return False;

		if(len(s) != len(t)):
			return False;

		keyMap = {};

		for i in range(len(s)):
			ele = s[i];
			if(keyMap.get(ele) == None):
				keyMap[ele] = 1;
			else:
				keyMap[ele] += 1;

		for i in range(len(t)):
			ele = t[i];
			if(keyMap.get(ele) == None or keyMap.get(ele) == 0):
				return False;
			keyMap[ele] -= 1;

		for key in keyMap:
			if(keyMap[key] != 0):
				return False;

		return True;


s = Solution();
print s.isAnagram("anagram","nagaram");
print s.isAnagram("rat","car");