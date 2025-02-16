#### HOMEWORK 4 ####

## Problem 1
'''
Write a function countdown to zero(start) that counts down from the given start number to 0,
printing each number. If the starting number is less than or equal to 0, 
the function should print a message “Enter a positive number”.
'''

def countdown_to_zero(start):
    if start <= 0:
        print("Enter a positive number")
    else:
        while start >= 0:
            print(start)
            start -= 1


## Problem 2
'''
Write a program that prints the U.S. presidential election years from 1992 to
present day, knowing that such elections occur every 4 years.
'''

def election_years():
    for i in range(1992, 2025, 4):
        print(i)


## Problem 3
'''
Write a function buzz(n) that prints the numbers from 1 to n. 
For multiples of 5, print “Buzz” instead of the number.
'''

def buzz(n):
    for i in range(1, n + 1):
        if i % 5 == 0:
            print("Buzz")
        else:
            print(i)


## Problem 4
'''
Write a function called negative sum(a list) that takes a list as an input. 
The function will return the sum of all negative numbers in the list. 
For example
negative_sum([-1, 2, -3])
should return −4.
'''

def negative_sum(lst):
    sum = 0
    for i in lst:
        if i < 0:
            sum += i
    return sum


## Problem 5
'''
Write a function called even positive sum(a list) that takes a list of integers as an input. 
The function will return the sum of all positive even numbers in the list 
(a positive even number is a number that is both positive and even). 
For example
negative_sum([-1, 2, -4, 3, 6])
should return 8.
'''

def even_positive_sum(lst):
    sum = 0
    for i in lst:
        if i > 0 and i % 2 == 0:
            sum += i
    return sum


## Problem 6
'''
Write a function called minimal element(a list) that takes a list as an
input. The function will return the minimal element in the list. For example
negative_sum ([1, 5, 2, 4])
should return 1.
'''

def minimal_element(lst):
    min = lst[0]
    for i in lst:
        if i < min:
            min = i
    return min


## Problem 7
'''
Write a function called is square(n) that checks whether a number is a
square or not. A number n is called a square if n = m2 for some integer m. For example,
9 is a square because 9 = 32. On the other hand, 20 is not a square because there is no
integer m such that m2= 20.
'''

def is_square(n):
    for i in range(n + 1):
        if i ** 2 == n:
            return True
    return False


## Problem 8
'''
Write a function that prints out all perfect square numbers between 1 and 150.
'''

def perfect_squares(n: int = 150):
    for i in range(1, n + 1):
        if is_square(i):
            print(i)


## Problem 9
'''
Write a function called sum cube(n) that calculates the sum of the cube of
all numbers between 1 and n. For example, sum cube(1) should return 1 because 1^3= 1.
Similarly, sum cube(2) should return 9 because 1^3+ 2^3= 9.
'''

def sum_cube(n):
    sum = 0
    for i in range(1, n + 1):
        sum += i ** 3
    return sum


## Problem 10
'''
Write a function named sum of digits(n) that takes a positive integer n
as input and returns the sum of its digits. For example
sum_of_digits (123) # Should return 6
sum_of_digits (135) # Should return 9
'''

def sum_of_digits(n):
    sum = 0
    while n > 0:
        sum += n % 10
        n = n // 10
    return sum