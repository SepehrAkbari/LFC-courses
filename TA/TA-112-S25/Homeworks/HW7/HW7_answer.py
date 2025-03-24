#### HOMEWORK 7 ####

## Problem 1
'''
(1) Write a function named recursive sum(alist) that takes a list of numbers as input
and returns the sum of the squares of all elements in the list. For example
alist = [1,2, -3]
recursive_sum(alist)
should return 1^2 + 2^2 + (−3)^2 = 14.
'''

def recursiveSum(lst):
    if len(lst) == 1: 
        return lst[0] ** 2
    return lst[0] ** 2 + recursiveSum(lst[1:])

'''
(2) Write another function non recursive sum(alist) to achieve the same goal
'''

def nonRecursiveSum(lst):
    sum = 0
    for i in range(len(lst)):
         lst[i] = lst[i] ** 2
    for j in lst:
        sum += j
    return sum


## Problem 2
'''
(1) Write a function name recursive sum power of two(n) that takes a positive integer
n as an input and returns the sum of the first n-powers of 2
1 + 2 + 2^2 + . . . + 2^n−1.
For example
print(recursive_sum_power_of_two (4))
should return 15 because 2^0 + 2^1 + 2^2 + 2^3 = 15.
'''
# this can also be written as 2 ** n - 1 + 2 ** (n - 1) - 1 + ... + 2 ** 1 - 1
def recursiveSumPowerOfTwo(n):
    if n == 0:
        return 0
    return 2 ** (n - 1) + recursiveSumPowerOfTwo(n - 1)

'''
(2) Write another non-recursive function to achieve the same goal
'''

def nonRecursiveSumPowerOfTwo(n):
    sum = 0
    for i in range(n):
        sum += 2 ** i
    return sum


### Remark 1.1 ###
'''
By geometric series:
S_n = a * (1 - r ** n) / (1 - r)

By plugging in a = 1 and r = 2 for our case:
S_n = (1 - 2 ** n) / (1 - 2) = 2 ** n - 1

So the general formula is: 
2 ** (n - 1)
'''


## Problem 3  
'''
(1) Write a recursive function recursive count vowels(s) that takes a string s as input
and returns the number of vowels (a, e, i, o, u) in s, ignoring case.
'''

def recursiveCountVowels(s):
    if len(s) == 0:
        return 0
    if s[0].lower() in "aeiou":
        return 1 + recursiveCountVowels(s[1:])
    return recursiveCountVowels(s[1:])

'''
(2) Write a non-recursive function to achieve the same goal.
'''

def nonRecursiveCountVowels(s):
    count = 0
    for i in s:
        if i.lower() in "aeiou":
            count += 1
    return count


## Problem 4
'''
(1) Write a recursive function recurive sum of powers(n, k) that computes the sum of
the first n integers raised to the power of k.
1^k+ 2^k+ . . . + n^k.
For example
sum_of_powers (3, 2)
should return 14 because 1^2 + 2^2 + 3^2 = 14.
'''
# this can be written as n ** k + (n - 1) ** k + ... + 1 ** k
def recursiveSumOfPowers(n, k):
    if n == 1:
        return 1 ** k
    return n ** k + recursiveSumOfPowers(n - 1, k)

'''
(2) Write a non-recursive version to achieve the same goal.
'''

def nonRecursiveSumOfPowers(n, k):
    sum = 0
    for i in range(1, n + 1):
        sum += i ** k
    return sum


## Problem 5
'''
An arithmetic progression is a sequence of numbers such that the difference
from any succeeding term to its preceding term remains constant throughout the sequence.
The constant difference is called the common difference of that arithmetic progression
(often denoted by d). For example
1, 4, 7, 10, 13, . . .
is an arithmetic progression with d = 3. An arithmetic sequence can be defined recursively
as follows
a_0 = a, a_n = a_{n−1} + d.
In the above example, a = 1, d = 3.
(1) Write a recursive function arithmetic sequence(a, d, n) that takes the first team
(a), the difference (d), and the index (n) as input and returns the n-th term of the
corresponding arithmetic sequence. For example
arithmetic_sequence (1, 3, 4)
should return 13.
'''

def arithmeticSequence(a, d, n):
    if n == 0:
        return a
    return arithmeticSequence(a, d, n - 1) + d

'''
(2) Write a non-recursive function to achieve the same goal. Hint: You can create a
sequence [a_0, a_1, . . . , a_{n−1}] using the append method (creating this list is 
not absolutely necessary but you might find it more intuitive.)
'''

def nonRecursiveArithmeticSequence(a, d, n):
    return a + n * d


## Problem 6
'''
The Lucas sequence is defined as follows, L_0 = 2, L_1 = 1 and for n ≥2:
L(n) = L(n − 1) + L(n − 2).
The first few terms of this sequence are
2, 1, 3, 4, 7, 11, . . .
(1) Write a recursive function named lucas(n) that returns that n-th Lucas number.
'''

def lucas(n):
    if n == 0:
        return 2
    if n == 1:
        return 1
    return lucas(n - 1) + lucas(n - 2)

'''
(2) Write a non-recursive version to achieve the same goal.
So far, we have learned how recursion works for linear recursion. The same principle
works for non-linear recursive relations as well.
'''

def nonRecursiveLucas(n):
    if n == 0:
        return 2
    if n == 1:
        return 1
    l0 = 2  # L(0)
    l1 = 1  # L(1)
    for i in range(2, n + 1):
        ln = l1 + l0  # L(n) = L(n-1) + L(n-2)
        l0 = l1 # L(n-2) = L(n-1)
        l1 = ln # L(n-1) = L(n)
    return ln


## Problem 7
'''
Let anbe the sequence defined as follows
a(0) = 1, a(n) = a(n − 1)2 + 1.
The first few terms of this sequence are
1, 2, 5, 26, 677 . . .
(1) Write a recursive function named sequence a(n) that returns that n-th term of this
sequence.
'''

def sequenceA(n):
    if n == 0:
        return 1
    return sequenceA(n - 1) ** 2 + 1

'''
(2) Write a non-recursive version to achieve the same goal.
'''

def nonRecursiveSequenceA(n):
    a = 1  # a(0) = 1
    for i in range(1, n + 1):
        a = a ** 2 + 1 # a(n) = a(n-1) ** 2 + 1
    return a


## Problem 8
'''
Let anbe the sequence defined as follows: b0 = b1 = 1 and
b_n = (b_{n−1}^2 + 2) / b_{n−2}
The first few terms of this sequence are
1, 1, 3, 11, 41, 153.
(1) Write a recursive function named sequence b(n) that returns that n-th term of this
sequence.
'''

def sequenceB(n):
    if n == 0 or n == 1:
        return 1
    return (sequenceB(n - 1) ** 2 + 2) / sequenceB(n - 2)

'''
(2) Write a non-recursive version to achieve the same goal.
'''

def nonRecursiveSequenceB(n):
    b0 = 1
    b1 = 1
    for i in range(2, n + 1):
        b = (b1 ** 2 + 2) / b0 # b_n = (b_{n−1}^2 + 2) / b_{n−2}
        b0 = b1 # b_{n−2} = b_{n−1}
        b1 = b # b_{n−1} = b_n
    return b

## USING LIST COMPREHENSION

## Problem 9
'''
(1) Given a list of numbers, create a new list containing the squares of these numbers.
For example
numbers = [1, 2, 3, 4, 5]
# Output: [1, 4, 9, 16, 25]
'''

def squares(numbers):
    return [x ** 2 for x in numbers]
    
'''
(2) From a list of integers, create a new list that contains only the even numbers. For
example
numbers = [1, 2, 11, 4, 9, 6]
# Output: [2, 4, 6]
'''

def evenNumbers(numbers):
    return [x for x in numbers if x % 2 == 0]

'''
(3) Given a list of strings, generate a new list where all the strings are in uppercase.
For example
words = ["hello", "world", "python"]
# Output: [" HELLO", "WORLD", "PYTHON "]
'''

def upperCase(words):
    return [x.upper() for x in words]

'''
(4) From a list of strings, create a new list that contains the first letter of each string.
For example
words = ["apple", "banana", "cherry"]
# Output: ["a", "b", "c"]
'''

def firstLetter(words):
    return [x[0] for x in words]


## Problem 10
'''
(1) Given a list of prices, create a new list that includes prices greater than $20. For
example
prices = [10, 25, 30, 5, 15]
# Output: [25, 30]
'''

def greaterThan20(prices):
    return [x for x in prices if x > 20]

'''
(2) Given a string, create a new list containing only the lowercase letters. For example
mixed_string = "HelloWorld"
# Output: ["e", "l", "l", "o", "o"]
'''

def lowerCase(mixed_string):
    return [x for x in mixed_string if x.islower()]

'''
(3) Given a list of integers, create a new list that includes only the negative numbers.
For example
numbers = [-10, 15, 0, -5, 20]
# Output: [-10, -5]
'''

def negativeNumbers(numbers):
    return [x for x in numbers if x < 0]

'''
(4) Given a list of strings, create a new list that contains only the strings that contain
the letter e. For example
words = ["apple", "banana", "cherry", "date", "fig"]
# Output: [" apple", "cherry", "date"]
For this problem, you might need to use the in operator.
'''

def containLetterE(words):
    return [x for x in words if 'e' in x]