#### HOMEWORK 5 ####

## Problem 1
'''
Determine the output of the following code:

(1) my_str = ’The cat in the hat’
print(my_str [0:3])
(2) my_str = ’The cat in the hat’
print(my_str [3:7])
(3) my_str = ’http://reddit.com/r/python ’
print(my_str [17: -2])
(4) my_str = ’http://reddit.com/r/python ’
protocol = ’http ://’
print(my_str[len(protocol):])
'''

# (1) The
# (2)  cat (note the space in the beginning)
# (3) /r/pyth
# (4) reddit.com/r/python


## Problem 2
'''
Write a function called count string(a list) that takes a list and returns the
number of strings in the list. For example
count_string (["Hello", 4, "5", 5.5])
should return 2 since there are two strings in this list.
'''

def countString(lst):
    for i in lst:
        if not isinstance(i, str):
            lst.remove(i)
    return len(lst)
# alternative solution : return len([i for i in lst if isinstance(i, str)])


## Problem 3
'''
Write a function called first equal last(string) that takes a string as a string as
input and returns True if the first and last characters of this string are the same. Otherwise,
return False. 

For example:

first_equal_last("hello")
should return False while

first_equal_last("dad")
should return True.
'''

def firstEqualLast(string):
    return string[0].lower() == string[-1].lower() and len(string) > 1


## Problem 4
'''
Write a function called print odd length(a list) that takes a list of strings as
input and prints out all strings with odd lengths in the list. For example:
print_odd_length ([’apple ’, ’orange ’, ’banana ’])
should print out ’apple’ since it is the only string with odd length.
'''

def printOddLength(lst):
    for i in lst:
        if len(i) % 2 == 0:
            lst.remove(i)
    return lst


## Problem 5
'''
Write a function print reverse(s) that takes a string and prints each character
in reverse order, starting from the last character and ending with the first. For example
print_reverse("test")
should print t, s, e,t in that order.
'''

def printReverse(s):
    for i in s[::-1]:
        print(i, end = ', ')


## Problem 6
'''
Write a function named longest string(a list) that takes a list of strings as
input and returns the longest string from the list. If there are multiple strings of the same
length, return the one that appears first. For example
longest_string (["Python", "is", "so", "fun", "and", "awesome"])
should return “awesome”.
'''

def longestString(lst):
    max = 0
    for i in lst:
        if len(i) > max:
            max = len(i)
            string = i
    return string


## Problem 7
'''
Write a function remove first and last(s) that takes a string s and returns
a new string with the first and last characters removed. For example
remove_first_and_last("banana")
should return “anan”. Recall that we can use a negative index to slice a string.
'''

def removeFirstAndLast(s):
    return s[1:-1]


## Problem 8
'''
Write a program that asks a user for their name and then prints the first
letter of their name
'''

def firstInitial():
    name = input("Enter your name: ")
    print(name[0])


## Problem 9
'''
Write a function called middle character(s) that returns the middle charac-
ter(s) of the string s. If the length of s is odd, return the middle character. If the length
of s is even, return the two middle characters.
For example:
middle_character("mango")
should return ‘n’ and
middle_character("orange")
should return ‘an’.
'''

def middleCharacter(s):
    if len(s) % 2 == 0:
        return s[len(s)//2 - 1:len(s)//2 + 1]
    else:
        return s[len(s)//2]
    

## Problem 10
'''
Write a function find index(a string, char) that returns the index of the last
occurrence of char in the string a string. For example, find index(“banana”, “a”) should
return 5.
'''

def findIndex(a_string, char):
    for i in range(len(a_string)-1, -1, -1):
        if a_string[i] == char:
            return i
        

## Problem 11
'''
Write a function called name end with y(a list) that takes a list of names
as input and returns the number of names that end with the letter y.
For example called name end with y([‘Jenny’, ‘John’, ‘Amy’]) should return 2
'''

def nameEndWithY(lst):
    count = 0
    for i in lst:
        if i[-1] == 'y':
            count += 1
    return count


## Problem 12
'''
Write a Python function sum of digits(n) that takes an integer n and returns
the sum of its digits. For example, sum of digits(132) should return 6.
'''

def sumOfDigits(n):
    return sum([int(i) for i in str(n)])

# alternative solution:
def sumOfDigits(n):
    sum = 0
    while n > 0:
        sum += n % 10
        n = n // 10
    return sum