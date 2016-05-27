# coding:utf8
# 使用头尾指针，做交换
def reverse(arr):
    if not arr:
        return

    i = 0
    j = len(arr) - 1

    while i < j:
        helper = arr[i]
        arr[i] = arr[j]
        arr[j] = helper
        i += 1
        j -= 1

arr = [1,2,3,4,5]
reverse(arr)
print arr