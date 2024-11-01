#### HOMEWORK 7 ####

## Problem 1
'''
Write a function named higher than average(d) that takes a dictionary d as
input. In this dictionary d, the keys represent students enrolled in Chem 101, and the
values represent their midterm scores. The function should return a list of students who
scored above the average midterm score. For example, for
d = {
"Alice": 85,
"Bob": 78,
"Charlie": 92,
"Daisy": 88,
"Ethan": 76}
higher_than_average(d)
the average score is 83.8. As a result, the function should return the list
["Alice", "Charlie", "Daisy"]
'''

def higherThanAverage(d):
    avg = sum(d.values())/len(d)
    return [k for k,v in d.items() if v > avg]


## Problem 2
'''
Write a function called total price(quantity dict, price dict) that takes in
quantity dict and price dict as input and returns the total cost of all items. Assume keys
in both dictionaries are the same, and the values in quantity dict are integers. For example,
total_price ({"fries": 7, "hot dogs": 9, "soda": 9}, {"fries": 1.5,
"hot dogs": 1, "soda": 1.1})
should return 29.4.
'''

def totalPrice(quantity, price):
    return sum([quantity[k] * price[k] for k in quantity.keys()])


## Problem 3
'''
Write a function called duplicated data(dictionar1, dictionary2) that takes
in dictionary1 and dictionary2 as parameters and returns a dictionary with key-value pairs
that are in both dictionaries. For example,
duplicated_data ({"apple": 10, "banana" : 20, "cherry" : 30}, {"
apple": 10, "banana" : 20, "mango" : 5})
should return
{"apple": 10, "banana": 20}.
'''

def duplicatedData(d1, d2):
    return {k:v for k,v in d1.items() if k in d2 and d1[k] == d2[k]}


## Problem 4
'''
Write a function update inventory(inventory, new shipment) that takes two
dictionaries as input. 1
•inventory: A dictionary representing current stock (e.g., ”apple”: 10, ”banana”: 5,
”orange”: 7).
•new shipment: A dictionary representing new items arriving (e.g., ”banana”: 10,
”orange”: 5, ”mango”: 3).
The function should update the inventory with the quantities from new shipment. If
an item in the shipment is not in the inventory, add it. The function should return the
updated inventory. For example
inventory = {"apple": 10, "banana": 5, "orange": 7}
new_shipment = {"banana": 10, "orange": 5, "mango": 3}
update_inventory(inventory , new_shipment)
should return
{"apple": 10, "banana": 15, "orange": 12, "mango": 3}
'''

def updateInventory(inventory, newShipment):
    for k,v in newShipment.items():
        if k in inventory:
            inventory[k] += v
        else:
            inventory[k] = v
    return inventory


## Problem 5
'''
Write a function called word count(sentence) that takes a sentence as input.
The function should return a dictionary where the keys are the words in the sentence and
the values represent the count of how many times each word appears. For this problem,
we do not treat uppercase and lowercase as identical. For example
sentence = "Whoever has learned how to listen to trees no longer
wants to be a tree"
word_count(sentence)
should return
{"Whoever": 1,
"has": 1,
"learned": 1,
"how": 1,
"to": 3,
"listen": 1,
"trees": 1,
"no": 1,
"longer": 1,
"wants": 1,
"be": 1,
"a": 1,
"tree": 1}
'''

def wordCount(sentence):
    return {k:sentence.split().count(k) for k in sentence.split()}


## Problem 6
'''
Write a function named mail count(alist) that takes a list of email strings as
input. Each email is a string with the following format:
"From stephen.marquard@uct.ac.za Sat Jan 7"
The function should return a dictionary where the keys are days of the week, and the
values represent the number of emails sent on each day. For example
emails = [
"From stephen.marquard@uct.ac.za Sat Jan 7",
"From louis@media.berkeley.edu Fri Jan 5",
"From zqian@umich.edu Fri Jan 5",
"From rjlowe@iupui.edu Thu Jan 4",
"From cwen@iupui.edu Sat Jan 7"
]
print(mail_count(emails))
should return
{"Sat": 2, "Fri": 2, "Thu": 1}
For this problem, you should use the split method to get the day of the week from an
email.
'''

def mailCount(alist):
    days = [email.split()[2] for email in alist if "From" in email]
    return {day: days.count(day) for day in set(days)}


## Problem 7
'''
Write a function called major count(d) that takes a dictionary as input. In
this dictionary, the keys represent student names, and the values indicate their respective
majors. The function should return a new dictionary where the keys are the majors and
the values are the corresponding counts of students enrolled in each major. For example
d = {
"Alice": "Biology",
"Bob": "Mathematics",
"Charlie": "Biology",
"David": "Computer Science",
"Eva": "Mathematics",
"Frank": "Computer Science",
}
major_count(d)
should return
{
"Biology": 2,
"Mathematics": 2,
"Computer Science": 2}
'''

def majorCount(d):
    return {k:list(d.values()).count(k) for k in set(d.values())}


## Problem 8
'''
Write a function named most frequent(alist) that accepts a list of integers as
input and returns the number that occurs most frequently. If there are ties for the most
frequent number, return the largest one among them.
alist = [1, 3, 2, 3, 4, 2, 5, 3, 2]
most_frequent(alist)
should return 3. Note that both 3 and 2 appear 3 times. We pick 3 because it is the bigger
number.
'''

def mostFrequent(alist):
    for i in sorted(set(alist), reverse = True):
        if alist.count(i) == max([alist.count(j) for j in set(alist)]):
            return i
    

## Problem 9
'''
Write a function named election result(votes) that takes a list of candidate
names as input and returns the winner of the election. If a candidate receives at least 50%
of the votes, that candidate is declared the winner. If no candidate meets this requirement,
the function should indicate that a reelection is necessary. For example
votes = ["Alice", "Bob", "Alice", "Charlie", "Bob", "Alice", "
Alice"]
election_result(votes)
should return ”Alice”. On the other hand
votes = ["Alice", "Bob", "Alice", "Charlie", "Bob", "Alice", "
Charlie"]
election_result(votes)
should return
"Reelection".
'''

def electionResult(votes):
    for i in set(votes):
        if votes.count(i) > len(votes)/2:
            return i
    return "Reelection"


## Problem 10
'''
Write a function named count digits(n) that takes an integer n as input and
returns a dictionary where the keys are the digits (0-9) and the values are the counts of
how many times each digit appears in n. For example
n = 1122334455
count_digit(n)
should return
{
1: 2,
2: 2,
3: 2,
4: 2,
5: 2
}
For this problem, you might want to convert an integer to a string and vice versa. This is
not absolutely necessary but it will make the problem a bit easier.
'''

def countDigits(n):
    return {int(k):str(n).count(k) for k in str(n)}


## Problem 11
'''
Write a function named product sales(sales data) that takes a list of dic-
tionaries representing product sales, where each dictionary contains the product name and
the quantity sold. The function should return a dictionary where the keys are product
names and the values are the total quantities sold. For example
sales_data = [
{"product": "apple", "quantity": 3},
{"product": "banana", "quantity": 2},
{"product": "apple", "quantity": 1},
{"product": "orange", "quantity": 4},
{"product": "banana", "quantity": 1}
]
product_sales(sales_data)
should return
{"apple": 4,
"banana": 3,
"orange": 4}
'''

def productSales(sales_data):
    result = {}
    for sale in sales_data:
        product = sale["product"]
        quantity = sale["quantity"]
        result[product] = result.get(product, 0) + quantity
    return result


## Problem 12
'''
Given the following nested dictionaries:
'''

grades = {
    "Alice": {
    "Math": 85,
    "English": 78,
    "Science": 92
    },
    "Bob": {
    "Math": 90,
    "English": 82,
    "Science": 88
    },
    "Charlie": {
    "Math": 95,
    "English": 97,
    "Science": 91
    }
}

'''
(1) Create a dictionary where the keys are student names and the values are their
average scores across Math, English, and Science.
'''

def averageScores(d):
    return {k:sum(v.values())/len(v) for k,v in d.items()}


'''
(2) Find the list of students who have the highest scores in Math.
'''

def highestMath(d):
    for i in d:
        if d[i]["Math"] == max([d[j]["Math"] for j in d]):
            return i

'''
(3) Find the list of students whose Math score is higher than their English score.
'''

def higherMath(d):
    return [k for k,v in d.items() if v["Math"] > v["English"]]