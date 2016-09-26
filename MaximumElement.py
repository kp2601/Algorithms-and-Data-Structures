''' 
You have an empty sequence, and you will be given  queries. Each query is one of these three types:

1 x  -Push the element x into the stack.
2    -Delete the element present at the top of the stack.
3    -Print the maximum element in the stack.
Input Format

The first line of input contains an integer, . The next  lines each contain an above mentioned query. (It is guaranteed that each query is valid.)
'''

# Enter your code here. Read input from STDIN. Print output to STDOUT
n = input()
s = []
m = [float('-inf')]
for each in xrange(n):
    op = map(int,raw_input().split())    
    if len(op) > 1:
        x = op[1]
        s.append(x)        
        if m[-1] <= x:
            m.append(x)
    elif op[0] == 2:
        if s:
            r = s.pop()
            if r == m[-1]:
                m.pop()
    else:
        if m:
            print m[-1]
        
            