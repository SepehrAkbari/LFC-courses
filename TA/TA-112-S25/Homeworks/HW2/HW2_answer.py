#### HOMEWORK 2 ####

## Problem 1
'''
Indicate whether the expression evaluates to True or False. x = 7, y = 9.
'''
# 1. True (7 > 5)
# 2. True (7 > 5 and 9 < 20)
# 3. False (7 (not)> 10 and 9 < 20)
# 4. True (7 (not)> 10 or 9 < 20)
# 5. False (7 (not)> 10 or 9 (not)> 20)
# 6. True (not (7 (not)> 10))
# 7. False (not (7 > 5 and 9 < 20))


## Problem 2
'''
What is the printed value of y in each of the following cases?
'''

# 1. 99 (executed on first block)
# 2. 5.0 (executed on second block)
# 3. 2 (executed on else block)


## Problem 3
'''
A student is taking a course with a Pass/Fail option. Their final grade is
determined by the final exam score and any bonus points they receive. The passing criteria
are as follows:
- The student passes if the total score, which is the sum of the exam score and bonus
points, is 80 or above.
- If the total score is below 80, the student fails.

Define variables that represent the final score and the bonus points of a student. Based on
these values, determine whether this student passes or fails the course.
'''

final_score = input("Enter the final score: ")
bonus_points = input("Enter the bonus points: ")

total_score = final_score + bonus_points

if total_score >= 80:
    print("Pass")
else:
    print("Fail")


## Problem 4
'''
A university classifies its size based on the number of students enrolled. The
rule for its classification system is as follows:
- A university is classified as “Medium-sized” if the number of students enrolled is
between 3,000 and 16,000 inclusive.
- If the number of students enrolled is outside this range, it is classified as not
medium-sized.

Write a program that takes the number of students enrolled as input. Determines if the
university is “Medium-sized” or not based on the given range.
'''

students = int(input("Enter the number of students: "))

if (3000 <= students <= 16000):
    print("Medium-sized")
else:
    print("Not medium-sized")


## Problem 5
'''
A small company in Madison Wisconsin offers benefits based on employee
work hours and tenure. The eligibility criteria for benefits are as follows: An employee is
eligible for benefits if at least one of the following conditions is satisfied:
(1) They have worked at least 40 hours per week and have been with the company for
2 years or more.
(2) Or, if they have worked at least 30 hours per week and have been with the company
for 5 years or more.

Write a Python program that takes the number of hours worked per week and years with
the company of an employee as input. Based on these values, determine whether this
employee is eligible for benefits.
'''

hours_worked = int(input("Enter the number of hours worked per week: "))
years = int(input("Enter the number of years with the company: "))

if (hours_worked >= 40 and years >= 2) or (hours_worked >= 30 and years >= 5):
    print("Eligible for benefits")
else:
    print("Not eligible for benefits")


## Problem 6
'''
Write a Python program that takes a password as input and prints:
- “Strong” if the password length is greater than 12 characters.
- “Moderate” if the password length is between 8 and 12 characters (inclusive).
- “Weak” if the password length is less than 8 characters.
'''

password = input("Enter the password: ")

if len(password) > 12:
    print("Strong")
elif 8 <= len(password) <= 12:
    print("Moderate")
else:
    print("Weak")


## Problem 7
'''
You are organizing an event where ticket prices vary based on the attendee's
age. Write a program that takes the age of an attendee as input and determines the ticket
price according to the following rules.
• Toddler (ages 0-2): Free.
• Children (ages 3-12) pay $10.
• Teenagers (ages 13-19) pay $15.
• Adults (ages 20-64) pay $20.
• Seniors (ages 65 and above) pay $8.
'''

age = int(input("Enter the age: "))
price = 0

if 0 <= age <= 2:
    price = 0
elif 3 <= age <= 12:
    price = 10
elif 13 <= age <= 19:
    price = 15
elif 20 <= age <= 64:
    price = 20
else:
    price = 8

print("Ticket price: $" + str(price))


## Problem 8
'''
A clothing store offers a discount based on the amount spent by a customer.
The discounts are applied as follows.
• If the total amount spent is greater than $200, the customer gets a 20 % discount.
• If the total amount spent is between $120 and $200, the customer gets a 15 %
discount.
• If the total amount spent is between $80 and $120, the customer gets a 10 %
discount.
• Otherwise, there’s no discount.
Define a variable that represents the amount spent and calculate the final payment.
'''

amount_spent = float(input("Enter the amount spent: "))

if amount_spent > 200:
    discount = 0.20
elif 120 <= amount_spent <= 200:
    discount = 0.15
elif 80 <= amount_spent <= 120:
    discount = 0.10
else:
    discount = 0

final_payment = amount_spent - (amount_spent * discount)
print("Final payment: $" + str(final_payment))


## Problem 9
'''
Amazon offers different shipping rates based on the weight of a package and
whether the customer has an Amazon Prime membership. It uses the following rules to
calculate shipping costs:
• Amazon Prime Members: All packages, regardless of weight, ship for free.
• Non-Prime Members:
(1) Zone 1 (Local): Packages up to 10 lb: $10. Packages over 10 lb: $20.
(2) Zone 2 (International): Packages up to 10 lb: $30, Packages over 10 lb: $50.
Write a program that calculates the shipping cost based on the variables that represent
package weight, destination zone, and whether the customer has Amazon Prime.
'''

prime_member = int(input("Are you an Amazon Prime member? (1 for Yes, 0 for No): "))

if prime_member == 1:
    shipping_cost = 0
else:
    weight = float(input("Enter the weight of the package: "))
    zone = int(input("Enter the destination zone (1 for Local, 2 for International): "))

    if zone == 1:
        if weight <= 10:
            shipping_cost = 10
        else:
            shipping_cost = 20
    else:
        if weight <= 10:
            shipping_cost = 30
        else:
            shipping_cost = 50

print("Shipping cost: $" + str(shipping_cost))


## Problem 10
'''
A childcare center provides financial assistance based on family income. The
assistance categories are:
• “Full Assistance” if the family income is $40,000 or less.
• “Partial Assistance” if the family income is between $40,001 and $70,000.
• “No Assistance” if the family income is above $70,000.
Write a Python program to ask the user to enter the family income. Based on their
answer, determine the type of assistance. Handles invalid inputs (e.g., non-numeric values)
gracefully using try-except.
'''

try:
    income = float(input("Enter the family income: "))

    if income <= 40000:
        assistance = "Full Assistance"
    elif 40001 <= income <= 70000:
        assistance = "Partial Assistance"
    else:
        assistance = "No Assistance"

    print("Assistance: " + assistance)
except ValueError:
    print("Invalid input. Please enter a numeric value.")
