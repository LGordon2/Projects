#!/usr/bin/env python

change = 14.76

hundreds = fifties = twenties = tens = fives = ones = 0
quarters = dimes = nickels = pennies = 0

while(change > 100):
  hundreds += 1
  change -= 100

while(change > 50):
  fifties += 1
  change -= 50

while(change > 20):
  twenties += 1
  change -= 20

while(change > 10):
  tens += 1
  change -= 10

while(change > 5):
  fives += 1
  change -= 5

while(change > 1):
  ones += 1
  change -= 1

while(change > .25):
  quarters += 1
  change -= .25

while(change > .10):
  dimes += 1
  change -= .10

while(change > .5):
  nickels += 1
  change -= .05

while(round(change, 2) > 0):
  pennies += 1
  change -= .01

print "Hundreds: %d, Fifties: %d, Twenties: %d, Tens: %d, Fives: %d, Ones: %d" % (hundreds, fifties, twenties, tens, fives, ones)
print "Quarters: %d, Dimes: %d, Nickels: %d, Pennies: %d" % (quarters, dimes, nickels, pennies)
