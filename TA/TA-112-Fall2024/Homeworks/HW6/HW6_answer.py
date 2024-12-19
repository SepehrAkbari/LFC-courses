#### HOMEWORK 6 ####

## Problem 1
'''
Write a function named three largest(alist) that takes a list of numbers as
input. The function should return a list containing the three largest values from alist,
sorted from lowest to highest. If the list contains fewer than three numbers, return the
original list sorted from lowest to highest. For example
three_largest ([8, 3, 1, 9, 12])
should return [8, 9, 12].
'''

def threeLargest(lst):
    if len(lst) < 3:
        return sorted(lst)
    return sorted(lst)[-3:]


## Problem 2
'''
Write a function named find median(alist) that takes a list of numbers alist
as input. The function should return the median value of this list. Recall that the median
is defined as follows
• If the list has an odd number of elements: The median is the middle value in the
sorted list.
• If the list has an even number of elements: The median is the average of the two
middle values.
For example
print(find_median ([7, 1, 4]))
should return 4 and
print(find_median ([7, 1, 4, 6]))
should return 4+6/2 = 5.
'''

def findMedian(lst):
    lst = sorted(lst)
    if len(lst) % 2 == 0:
        return (lst[len(lst) // 2] + lst[len(lst) // 2 - 1]) / 2
    return lst[len(lst) // 2]


## Problem 3
'''
Write a function named sort by price(products) that takes a list of tuples,
where each tuple contains a product name and its price (e.g., (”apple”, 1.50)). The function
should return a new list of these products sorted by their price. For example
sort_by_price ([("banana", 1.5), ("apple", 2.91) , ("orange", 2.25)
])
should return
[("banana", 1.5), ("orange", 2.25), ("apple", 2.91)].
1
To solve this problem, you need to create another function say, get price(a product) that
takes a product as an input and returns its price. See the practice problem file for some
more similar examples.
'''

def getPrice(product):
    return product[1]

def sortByPrice(lst):
    return sorted(lst, key = getPrice)


## Problem 4
'''
Write a function named sort names(name list) that takes a list of names
name list as input. The function should return a new list with these names sorted in
alphabetical order, ignoring case sensitivity (recall that, in Python lowercase letters are
greater than all uppercase letters.) For example
sort_names (["anne", "charlie", "David", "Armin"])
should return [”anne”, ”Armin”, ”charlie”, ”David”]
'''

def sortNames(lst): 
    return sorted(lst, key = str.lower)


## Problem 5
'''
Write a function named sort title(alist) that takes a list of book titles as
input. The function should return a new list with these titles sorted by the number of
words in each title. For example
alist = ["For whom the bell tolls",
"The old man and the sea",
"Please look after mom",
"Siddhartha"]
print(sort_title(alist))
should return
["Siddhartha", "Please look after mom", "For whom the bell tolls",
"The old man and the sea"].
'''

def getLength(title):
        return len(title.split())

def sortTitle(lst):
    return sorted(lst, key = getLength)


## Problem 6
'''
Write a function named choose best book(books and ratings) that takes a
list of tuples, where each tuple contains a book title and its rating. The function should
return the name of the book with the highest rating. For simplicity, assume that all the
ratings are different. For example
books_and_ratings = [
("Siddhartha", 4.9),
("The Old Man and the Sea", 4.7),
("For Whom the Bell Tolls", 4.8),
("Please Look After Mom", 4.6)
]
print(choose_best_book(books_and_ratings))
should return ”Siddhartha”
'''

def getRating(book):
        return book[1]

def bestBook(books):
    return max(books, key = getRating)[0]


## Problem 7
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


## Problem 8
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


### Remark 2.1 ###
'''
By geometric series:
S_n = a * (1 - r ** n) / (1 - r)

By plugging in a = 1 and r = 2 for our case:
S_n = (1 - 2 ** n) / (1 - 2) = 2 ** n - 1

So the general formula is: 
2 ** (n - 1)
'''


## Problem 9
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


## Problem 10
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

'''
(3) Use list comprehension and one of your functions to calculate the ratio
1^k+ 2^k+ . . . + n^k / n^(k+1),
for k = 3 and n ∈[10, 10^2, 10^3, 10^4, 10^5, 10^6]
'''
A = [10, 10**2, 10**3, 10**4, 10**5, 10**6]
def ratio(n_values = A, k = 3):
    ratios = []
    for n in n_values:
        ratios.append(nonRecursiveSumOfPowers(n, k) / n ** (k + 1))
    return ratios

### Remark 2.2 ###
'''
The sum and denominator both grow at the same rate, (n ∈ A) ** (3 + 1), so the ratio converges to 1/4.

By calculus (limits):
lim n -> ∞ [(1^k + 2^k + ... + n^k) / n^(k + 1)] = 1 / (k + 1)

So the ratio converges to 1 / (k + 1) but never reaches it.
'''

## Problem 11
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


## Problem 12
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


## Problem 13
'''
Let anbe the sequence defined as follows
a(0) = 1, a(n) = a(n −1)2 + 1.
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


## Problem 14
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