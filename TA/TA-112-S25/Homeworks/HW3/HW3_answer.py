#### HOMEWORK 3 ####

## Problem 1
'''
Write a function called poly perimeter that takes in two parameters,
len side, and num sides, and returns the perimeter of the polygon. 
The perimeter of a polygon is the length of each side times the number of sides. 
For example, poly perimeter(4,5) should return 20.
'''

def poly_perimeter(len_side, num_sides):
    return (len_side * num_sides)


## Problem 2
'''
Create a function called get hypotenuse that takes in two parameters, 
a and b, which represent the lengths of the two legs of a right triangle. 
The function should return the length of the hypotenuse. Use the Pythagorean theorem
hypotenuse ** 2 = a**2 + b**2, to calculate and return the hypotenuse.
'''

def get_hypotenuse(a, b):
    return ((a**2 + b**2) ** 0.5)


## Problem 3
'''
Write a function called find distance that takes in four parameters, 
x1, y1, x2, y2, and returns the distance between these two points (x1,y1) and (x2,y2). 
The distance is given by the following formula which is a consequence of the Pythagorean theorem
d = sqrt((x1 - x2)**2 + (y1 - y2)**2)
'''

def find_distance(x1, y1, x2, y2):
    return (((x1 - x2)**2 + (y1 - y2)**2) ** 0.5)


## Problem 4
'''
Write a function called total string length that takes in two parameters, str1
and str2, and returns the total length of these two strings.
'''

def total_string_length(str1, str2):
    return len(str1) + len(str2)


## Problem 5
'''
Write a function called address that combines 3 different string address parameters 
(city, state, and zip) and returns a user’s address. After the city and state inputs, 
add a comma and a space. For example,
address(’Seattle’, ’WA’, ’98105’) should return “Seattle, WA, 98105”.
'''

def address(city, state, zip):
    return (city + ", " + state + ", " + zip)


## Problem 6
'''
Write a function apply discount(price, is member) that applies a discount based on membership status:
• 10% discount for members.
• No discount for non-members.
For example
apply_discount(100, True)
should return 90.
'''

def apply_discount(price, is_member):
    if is_member:
        return price * 0.9
    else:
        return price
    

## Problem 7
'''
Write a function called shipping price that takes two arguments: 
weight and express and returns shipping cost based on the weight of the 
package and whether express shipping is selected:
 Standard Shipping:
– $5 for weights up to 2 lbs – $10 for weights above 2 lbs
• Express Shipping:
– $10 for weights up to 2 lbs – $20 for weights above 2 lbs
For example
calculate_shipping_cost(4, True)
should return 20.
'''

def calculate_shipping_cost(weight, express):
    if express:
        if weight <= 2:
            return 10
        else:
            return 20
    else:
        if weight <= 2:
            return 5
        else:
            return 10
        

## Problem 8
'''
Write a function called final price that takes three arguments: 
price, weight, and express and returns the final total price. 
The final price is the sum of the price and the shipping cost which is calculated as follows
• For purchase prices $100 or more, shipping is free.
• For purchase prices below $100, the shipping fee is calculated based on the formula
from the previous problem.
Your function should call the shipping price from the previous problem.
'''

def final_price(price, weight, express):
    if price >= 100:
        return price
    else:
        return price + calculate_shipping_cost(weight, express)


## Problem 9
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
    

## Problem 10
'''
Write a function buzz(n) that prints the numbers from 1 to n. 
For multiples of 3, print “Buzz” instead of the number.
'''

def buzz(n):
    for i in range(1, n + 1):
        if i % 3 == 0:
            print("Buzz")
        else:
            print(i)


## Problem 11
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


## Problem 12
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


## Problem 13
'''
Write a function called maximal element(a list) that takes a list as an input.
The function will return the maximal element in the list. For example
negative_sum([1, 5, 2, 4])
should return 5.
'''

def maximal_element(lst):
    max = lst[0]
    for i in lst:
        if i > max:
            max = i
    return max


## Problem 14
'''
Write a function called is prime(n) that checks whether a number is a prime number or not. 
A prime number is a number whose divisors are 1 and itself. 
For example: 2, 5, 7, and 11 are prime numbers while 6 is not.
'''

def is_prime(n):
    if n < 2:
        return False
    if n == 2:
        return True
    for i in range(2, n):
        if n % i == 0:
            return False
    return True


## Problem 15
'''
Write a function called sum divisors(n) that calculates the sum of all of the divisors of n.
'''

def sum_divisors(n):
    sum = 0
    for i in range(1, n + 1):
        if n % i == 0:
            sum += i
    return sum


## Problem 16
'''
Write a function called sum square(n) that calculates the sum of the squares
of all numbers between 1 and n. 
For example, sum square(1) should return 1 and sum square(2) should return 5.
'''

def sum_square(n):
    sum = 0
    for i in range(1, n + 1):
        sum += i ** 2
    return sum


## Problem 17
'''
An integer n is called a perfect square if n = m2 for some integer n. 
For example, 4 is a perfect square because 4 = 22. 
On other other hand, 6 is not a perfect square. 
Write a function called is square(n) to check whether a number n is a perfect square.
'''

def is_square(n):
    for i in range(n + 1):
        if i ** 2 == n:
            return True
    return False


## Problem 18
'''
Write a function that prints out all perfect square numbers between 1 and 100.
'''

def perfect_squares():
    for i in range(1, 101):
        if is_square(i):
            print(i)


## Problem 19
'''
Write a function that takes a string as an input and returns True 
if this string contains the lowercase letter h. Otherwise, return False.
'''

def contains_h(s):
    for i in s:
        if i == 'h':
            return True
    return False