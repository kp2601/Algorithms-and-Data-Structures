'''You are a waiter at a party. There are  stacked plates. Each plate has a number written on it. You start picking up the plates from the top one by one and check whether the number written on the plate is divisible by (a prime). The starting value of  is . If the number is divisible, you stack that plate separately with other  divisible plates. If not, you stack that plate separately with the other plates that are not divisible by .

In the next iteration, the value of  changes to the next prime number after . You check the plates from the pile that were not divisible by  in the last iteration. You repeat this process a number of times. By doing this process  times, you end up getting different piles of plates. The plates that are not divisible by the  prime (which is our last iteration), from the last pile of plates. Say you have  (it is clear that  is either  or ) different piles of plates. Starting from the first pile, print the number written on the plate while removing plates from a pile in the same order as described above. Do this process for all the  piles. Print one value in a single line.

Input Format

The first line contains two space separated integers,  and . 
The next line contains  space separated integers representing the initial pile of plates. The leftmost value represents the bottom plate of the pile.'''

# Enter your code here. Read input from STDIN. Print output to STDOUT
def isPrime(num):
	"""Checks num for primality. Returns bool."""

	if num == 2:
		return True
	elif num < 2 or not num % 2:	# even numbers > 2 not prime
		return False

		# factor can be no larger than the square root of num
	for i in range(3, int(num ** .5 + 1), 2):
		if not num % i: return False
	return True

def generatePrimes(n):	
	
	primes = [2,]
	noOfPrimes = 1	# cache length of primes for speed
	testNum = 3 # number to test for primality

	while noOfPrimes < n:
		if isPrime(testNum):
			primes.append(testNum)
			noOfPrimes += 1
		testNum += 2

	return primes



n, Q = map(int, raw_input().split())
prime = generatePrimes(Q)
p = map(int, raw_input().split())
piles = {}
piles[-1] = p
num = []
for q in xrange(Q):
    div = []
    ndiv = []
    p = piles[-1]
    num.append(prime[q])
    while p:
        x = p.pop()
        curr = prime[q]
        if x % curr == 0:
            div.append(x)
        else:
            ndiv.append(x)
        piles[curr] = div
        piles[-1] = ndiv
    
for key in num:
    if key > 0:
        s = piles[key]
        while s:
            print s.pop()
    
s = piles[-1]
while s:
    print s.pop()
    
