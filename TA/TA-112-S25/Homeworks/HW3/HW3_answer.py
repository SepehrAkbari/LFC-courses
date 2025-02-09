#### HOMEWORK 3 ####

## Problem 1
'''
Write a function that takes a number of minutes as input, converts it to
seconds, and prints out the result.
'''

def minutes_to_seconds(minutes):
    print(minutes * 60)

## Problem 2
'''
Write a function that takes the total bill amount and the tip percentage as
inputs, and print out the total amount including the tip.
'''

def total_bill(bill_amount, tip_percentage):
    tip = bill_amount * (tip_percentage / 100)
    total_amount = bill_amount + tip
    print(total_amount)

## Problem 3
'''
Write a function that takes the speed and speed limit as inputs, and prints
out the speeding fine. Here are the rules:
• If the driver is within the speed limit, there is no fine.
• If the driver exceeds the speed limit by up to 10 km/h, the fine is $50.
• If the driver exceeds the limit by more than 10 km/h, the fine is $100.
Here are two examples to demonstrate this problem. If the speed limit is 60 km/h and
the driver is going 65 km/h, the fine is $50. If the driver is going 82 km/h, the fine is $100.
'''

def speeding_fine(speed, speed_limit):
    if speed <= speed_limit:
        fine = 0
    elif speed <= speed_limit + 10:
        fine = 50
    else:
        fine = 100

    print("Fine: $" + str(fine))


## Problem 4
'''
Write a function to process price at a movie theater. The function should
take age as an input and print out the price of a movie ticket based on a person's age. The
ticket prices are as follows:
• Below 5: Free.
• 6-12: $15
• 12 to 64: $20
• 65 and older: $10
'''

def movie_ticket_price(age):
    if age <= 5:
        price = 0
    elif 6 <= age <= 12:
        price = 15
    elif 12 < age <= 64:
        price = 20
    else:
        price = 10

    print("Ticket price: $" + str(price))


## Problem 5
'''
Write a function to process a bank withdrawal. The function should take
two inputs: the balance and the withdrawal amount. The function should do the following
• If there are enough funds, subtract the withdrawn amount from the balance, and
print out the remaining balance.
• If the withdrawal amount is greater than the balance, the function should print
“Insufficient funds” instead of reducing the balance.
'''

def bank_withdrawal(balance, withdrawal_amount):
    if withdrawal_amount <= balance:
        balance -= withdrawal_amount
        print("Remaining balance: $" + str(balance))
    else:
        print("Insufficient funds")
    

## Problem 6
'''
Write a function called poly perimeter that takes in two parameters,
len side, and num sides, and returns the perimeter of the polygon. 
The perimeter of a polygon is the length of each side times the number of sides. 
For example, poly perimeter(4,5) should return 20.
'''

def poly_perimeter(len_side, num_sides):
    return (len_side * num_sides)


## Problem 7
'''
Create a function called get hypotenuse that takes in two parameters, 
a and b, which represent the lengths of the two legs of a right triangle. 
The function should return the length of the hypotenuse. Use the Pythagorean theorem
hypotenuse ** 2 = a**2 + b**2, to calculate and return the hypotenuse.
'''

def get_hypotenuse(a, b):
    return ((a**2 + b**2) ** 0.5)


## Problem 8
'''
Write a function called find distance that takes in four parameters, 
x1, y1, x2, y2, and returns the distance between these two points (x1,y1) and (x2,y2). 
The distance is given by the following formula which is a consequence of the Pythagorean theorem
d = sqrt((x1 - x2)**2 + (y1 - y2)**2)
'''

def find_distance(x1, y1, x2, y2):
    return (((x1 - x2)**2 + (y1 - y2)**2) ** 0.5)


## Problem 9
'''
Write a function called total string length that takes in two parameters, str1
and str2, and returns the total length of these two strings.
'''

def total_string_length(str1, str2):
    return len(str1) + len(str2)


## Problem 10
'''
Write a function called address that combines 3 different string address parameters 
(city, state, and zip) and returns a user’s address. After the city and state inputs, 
add a comma and a space. For example,
address(’Seattle’, ’WA’, ’98105’) should return “Seattle, WA, 98105”.
'''

def address(city, state, zip):
    return (city + ", " + state + ", " + zip)


## Problem 11
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