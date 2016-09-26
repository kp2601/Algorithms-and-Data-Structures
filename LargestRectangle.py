''' 
There are  buildings in a certain two-dimensional landscape. Each building has a height. If you join  adjacent buildings, they will form a solid rectangle of area .

Given  buildings, find the greatest such solid area formed by consecutive buildings.

Input Format 
The first line contains , the number of buildings altogether. 
The second line contains  space-separated integers, each representing the height of a building.

'''


# Enter your code here. Read input from STDIN. Print output to STDOUT
n = input()
b = map(int, raw_input().split())
s = []
mx = -1
for i in xrange(n+1):    
    if i == n:
        while s:
            top = b[s.pop()]
            if s:
                area = top * (i - s[-1] -1)
            else:
                area = top * i
            if area > mx:
                mx = area
    elif (not s) or b[s[-1]] <= b[i]:
        s.append(i)
    else:        
        while s and b[s[-1]] > b[i]:
            top = b[s.pop()]
            if s:
                area = top * (i - s[-1] -1)
            else:
                area = top * i
            if area > mx:
                mx = area
        s.append(i)
print mx
            