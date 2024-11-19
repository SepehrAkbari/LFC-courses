#### HOMEWORK 9 ####

import numpy as np 
import matplotlib.pyplot as plt

## Problem 1
'''
Given the following sets
'''
s1 = {1, 2, 3, 4, -2, -3}
s2 ={1, 2, 5, 7}
'''
Do the following tasks.
(1) Add 5 and 6 to s1.
'''

s1.add(5)
s1.add(6)

'''
(2) Find the union of s1 and s2.
'''

s1.union(s2)

'''
(3) Find the number of elements that belong to both s1 and s2.
'''

len(s1.intersection(s2))

'''
(4) Find the list of elements that belong to s1 but not s2.
'''

list(s1.difference(s2))


## Problem 2
'''
In a school, students are enrolled in different courses. The sets A and B
represent students enrolled in Mathematics and Physics courses, respectively:
'''

A = {"John", "Sarah", "Mike", "Anna", "David"}
B = {"Sarah", "Mike", "David", "Alice"}

'''
(1) Find the set of students who are enrolled in both Mathematics and Physics.
'''

A.intersection(B)

'''
(2) Find the set of students who are enrolled in either Mathematics or Physics.
'''

A.union(B)

'''
(3) How many students are enrolled in Mathematics but not in Physics?
'''

len(A.difference(B))

'''
(4) Find the list of students who are enrolled in only one of the two courses.
'''

list(A.symmetric_difference(B))


''' note:
Please do the following problems using arithmetic operations on arrays (that means, you
should avoid using loops and list comprehension).
'''

## Problem 3
'''
(1) Create a numpy array with integers from 1 to 10 (inclusive).
'''

npArr1 = np.arange(1, 11)

'''
(2) Create a new array by adding 5 to each element of the original array.
'''

npArr2 = npArr1 + 5

'''
(3) Create another new array by multiplying each element of the original array by 3.
'''

npArr3 = npArr1 * 3

'''
(4) Create a final array by squaring each element of the original array.
'''

npArr4 = npArr1 ** 2


## Problem 4
'''
Given the following numpy array:
'''

my_arr = np.array([1, -1, 3, 5, 7, 12])

'''
(1) Create a numpy array containing the squares of the elements in my arr.
'''

my_sqrs = my_arr ** 2

'''
(2) Create a numpy array containing the square roots of the non-negative elements in
my arr (ignore the negative elements). Round the result to 2 decimal places.
'''

my_sqrts = np.sqrt(my_arr[my_arr >= 0]).round(2)

'''
(3) Create a numpy array containing the exponential of the elements in my arr. Round
the result to 2 decimal places.
'''

my_exp = np.exp(my_arr).round(2)

'''
(4) Create a numpy array containing the inverse of the elements in my arr. Round the
result to 2 decimal places.
'''

my_inv = (1 / my_arr).round(2)


## Problem 5
'''
Given the following numpy arrays, where each element represents the radius
and height of a different cylinder.
'''

radii = np.array([1, 2.1, 3, 4.1])
height = np.array([3, 4, 2.5, 10])

'''
Create a new array that calculates the volume of the corresponding cylinder. The formula
for the volume is given by

A = pi*r^2*h,

where r is the radius and h is the height.
'''

volumes = np.pi * radii ** 2 * height


## Problem 6
'''
Given the following numpy array
'''

my_arr = np.array([1, 2,-3, 4, 9, 10])

'''
Use boolean indexing to answer the following questions.
(1) Create a new array that contains only the positive elements from the original array.
'''

my_pos = my_arr[my_arr > 0]

'''
(2) Create a new array that contains only the elements that are multiples of 3 from the
original array
'''

my_mult3 = my_arr[my_arr % 3 == 0]


## Problem 7
'''
Use the np.linspace() method to plot the graph of the following function over
the interval [0,2]

f = e^−x + 3sin(x).
'''

x = np.linspace(0, 2, 100) # im using 100 points, but you can use more or less
y = np.exp(-x) + 3 * np.sin(x) 

plt.plot(x, y)
plt.show()