# coding:utf8
# 逻辑清晰：使用hash表来存放secret每一位出现的次数；逐位比对secret和guess，如果相等bull加1，并且hash表对应key-1；如果不等，将guess位的数字插入到临时表中，根据临时表和hash表来确定cow
class Solution(object):
    def getHint(self, secret, guess):
        mapA = {}
        for s in secret:
            if mapA.get(s) is not None:
                mapA[s] += 1
            else:
                mapA[s] = 1

        cursor = 0
        bullNum = 0
        cowNum = 0
        helper = []
        for s in guess:
            if s == secret[cursor]:
                bullNum += 1
                mapA[s] -= 1
            else:
                helper.append(s)
            cursor += 1

        for s in helper:
            if mapA.get(s) is not None:
                if mapA.get(s) > 0:
                    cowNum += 1
                    mapA[s] -= 1
        return '%d%s%d%s'%(bullNum, 'A', cowNum, 'B')

s = Solution()

print s.getHint("11231","01112")
print s.getHint("1122","1222")