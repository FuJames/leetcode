# coding:utf8
# python list : append 在队尾；pop默认在队尾，也可以选择下标，0表示队头；
class Queue(object):
    def __init__(self):
        self.queue = []

    def push(self, x):
        self.queue.append(x)

    def pop(self):
        if not self.empty():
            self.queue.pop(0)

    def peek(self):
        if not self.empty():
            return self.queue[0]
        return None
    def empty(self):
        return len(self.queue) == 0

s = Queue()
print s.peek()

