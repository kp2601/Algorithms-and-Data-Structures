''' 
In this challenge, you must implement a simple text editor. Initially, your editor contains an empty string, . You must perform  operations of the following  types:

append - Append string  to the end of .
delete - Delete the last  characters of .
print - Print the  character of .
undo - Undo the last (not previously undone) operation of type  or , reverting  to the state it was in prior to that operation.
Input Format

The first line contains an integer, , denoting the number of operations. 
Each line  of the  subsequent lines (where ) defines an operation to be performed. Each operation starts with a single integer,  (where ), denoting a type of operation as defined in the Problem Statement above. If the operation requires an argument,  is followed by its space-separated argument. For example, if  and , line  will be 1 abcd.
'''

# Enter your code here. Read input from STDIN. Print output to STDOUT
s = ''
undo = []
n = input()
for each in xrange(n):    
    op = raw_input().split()
    if len(op) > 1:
        if op[0] == '1':
            x = op[1]
            undo.append(s)
            s += x                        
        elif op[0] == '2':
            k = int(op[1])
            undo.append(s)
            s = s[:-k]            
        else:
            k = int(op[1])
            if s:
                print s[k-1]
            else:
                print ''
    else:        
        s = undo.pop()
        