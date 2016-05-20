class Stack(object):
    def __init__(self):
        self.stack = []

    def push(self, x):
        self.stack.append(x)

    def pop(self):
        if self.stack:
            return self.stack.pop()

    def top(self):
        if self.stack:
            return self.stack[len(self.stack) - 1]

    def empty(self):
        return not self.stack

s = Stack()
s.push(1)
s.push(2)
print s.top()