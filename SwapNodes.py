# Enter your code here. Read input from STDIN. Print output to STDOUT
from collections import deque

class Node:
    left = None
    right = None
    data = None
    depth = 1
    
    def __init__(self, data):
        self.data = data
        
n = input()
root = Node(1)
q = deque()
q.append(root)

height = {}

for i in xrange(0, n):    
    left, right = map(int, raw_input().split())        
    curr = q.popleft()
    if curr.depth not in height:
        height[curr.depth] = [curr]
    else:
        height[curr.depth].append(curr)
    if left > -1 :
        curr.left = Node(left)
        curr.left.depth = curr.depth + 1
        q.append(curr.left)        
    else:
        curr.left = None
    if right > -1 :
        curr.right = Node(right)
        curr.right.depth = curr.depth + 1
        q.append(curr.right)
    else:
        curr.right = None
        
        
t = input()
k_list = []
for i in xrange(0, t):
    k = input()
    k_list.append(k)


def inorder(root):
    stack = []
    while stack or root:
        if root != None:
            stack.append(root)
            root = root.left
        else: # we are now returning: pop and print the current node
            root = stack.pop()
            print root.data,
            root = root.right
        
    
    
for k in k_list:
    for key,val in height.iteritems():
        if key % k == 0:                                    
            for each in val:                
                each.left, each.right = each.right, each.left
    inorder(root)
    print 