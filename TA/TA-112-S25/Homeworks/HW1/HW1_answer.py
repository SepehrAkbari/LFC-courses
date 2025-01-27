#### SECTION 2.15 ####

## Exercise 2
'''
Write a program that uses input to prompt a user for their name
and then welcomes them.
'''
name = input("Enter your name: ")
print("Hello", name)


## Exercise 3
'''
Write a program to prompt the user for hours and rate per hour to
compute gross pay.
'''
hours = float(input("Enter hours: "))
rate = float(input("Enter rate: "))
pay = round(hours * rate, 2)
print("Pay:", pay)


## Exercise 4
'''
Assume that we execute the following assignment statements:
width = 17
height = 12.0
For each of the following expressions, write the value of the expression and the
type (of the value of the expression).
1. width//2
2. width/2.0
3. height/3
4. 1 + 2 * 5
'''
# 1. 8, int
# 2. 8.5, float
# 3. 4.0, float
# 4. 11, int


## Exercise 5
'''
Write a program which prompts the user for a Celsius temperature,
convert the temperature to Fahrenheit, and print out the converted temperature.
'''
celsius = input("Enter Celsius temperature: ")
fahrenheit = (celsius * 9/5) + 32
print("Fahrenheit temperature: ", fahrenheit)



#### WORKSHEET PROBLEMS ####

## Problem 1
'''
What will be the printed value in each of the following cases?
'''
# 1. 10
# 2. 9
# 3. 10


## Problem 2
'''
Find the correct values for x, y, and z after the following statements execute.
'''
# x = 9
# y = 8
# z = 6


## Problem 3
'''
Find the value of x after the statements execute in each of the following cases.
'''
# 1. x = 12
# 2. x = 18
# 3. x = 33


## Problem 4
'''
Define two variables x and y, with values 21 and 4. Calculate their sum, difference, product, 
quotient, and integer quotient. Assign these results to new variables and print them.
'''
x = 21
y = 4

sum = x + y
difference = x - y
product = x * y
quotient = x / y
int_quotient = x // y

print("Sum: ", sum)
print("Difference: ", difference)
print("Product: ", product)
print("Quotient: ", quotient)
print("Integer Quotient: ", int_quotient)


## Problem 5
'''
Define two variables length and width that represent the sides of a rectangle.
Assign the values 10 and 6 to these variables, respectively, 
and then print the area and the circumference.
'''
length = 10
width = 6

area = length * width
circumference = 2 * (length + width)

print("Area: ", area)
print("Circumference: ", circumference)


## Problem 6
'''
Evaluate the following expressions. Store the result in a variable and print it. 
What is the type of the result in each of the cases? Explain.
'''
# 1
a = 2
b = 5
c = 1 
type(3 * (a**2 + 2*b**3) - 2**c) # integer

# 2
a = 3
b = 1
c = 2
type(2**(a-b*c) - a/c) # float

# 3
a = 3
b = 5
c = -2
type((b%a - c) * c**2) # integer


## Problem 7
'''
Create three variables, first name, middle name, and last name, 
and assign them your first, middle, and last names, respectively. 
Concatenate these variables to form your full name and print it. 
What if someone does not have a middle name?
'''
first_name = "John"
middle_name = "Doe"
last_name = "Smith"

full_name = first_name + " " + middle_name + " " + last_name
print("Full Name: ", full_name)

# If someone does not have a middle name, you can assign an empty string to the middle name variable
middle_name = ""
full_name = first_name + " " + middle_name + " " + last_name
print("Full Name: ", full_name)


## Problem 8
'''
Assign an integer value to a variable age and a string value to a variable name. 
Use type conversion to concatenate them into a sentence like “John is 25 years old” and print it.
'''
age = 25
name = "John"

phrase = name + " is " + str(age) + " years old"
print(phrase)