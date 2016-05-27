# coding:utf8
# 交换两个变量的值，用python方便

a ,b = 1, 2

# 方法1：
a, b = b, a # 会先把a保存起来
print a,b

a ,b = 1, 2
# 方法2：
a ^= b
b ^= a
a ^= b
print a,b