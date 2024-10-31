'''
Author @ Sepehr Akbari
Date: Feb 2024
Desc:
    A vending machine serves chips, fruit, nuts, juice, water, and coffee. 
    The machine owner wants a daily report indicating what items sold that day. 
    Given boolean values (1 or 0) indicating whether or not at least one of 
    each item was sold (in the order chips, fruit, nuts, juice, water, and coffee), 
    output a list for the owner. If all three snacks were sold, output "All-snacks" 
    instead of individual snacks. Likewise, output "All-drinks" if appropriate. 
    For coding simplicity, output a space after every item, including the last item.
'''

chipsSold = int(input("Chips sold: "))
fruitSold = int(input("Fruit sold: "))
nutsSold = int(input("Nuts sold: "))
juiceSold = int(input("Juice sold: "))
waterSold = int(input("Water sold: "))
coffeeSold = int(input("Coffee sold: "))

if (not chipsSold and not fruitSold and not nutsSold and not juiceSold and not waterSold and not coffeeSold):
   print('No items ', end='')
else: 
   if (chipsSold and fruitSold and nutsSold):
      print('All-snacks ', end='')
   else:
      if chipsSold: 
         print('Chips ', end='')
     
      if fruitSold:
         print('Fruit ', end='')
     
      if nutsSold:
         print('Nuts ', end='')

   if juiceSold and waterSold and coffeeSold:
      print('All-drinks ', end='')
   else:
      if juiceSold:
         print('Juice ', end='')
     
      if waterSold:
         print('Water ', end='')
     
      if coffeeSold:
         print('Coffee ', end='')

print()