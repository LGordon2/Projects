#!/usr/bin/env python

def to_binary(number):
  if number < 2:
    return "0b"+repr(number)
  return to_binary(number / 2) + repr(number % 2)

def to_decimal(number):
  new_num = 0
  exponent = 0
  for num in number[-1::-1]:
    if num == 'b':
      return new_num
    if num == '1':
      new_num += 2 ** exponent 
    exponent += 1
