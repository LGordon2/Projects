#!/usr/bin/env python

orig = range(2,10000)
index = 0
while index < len(orig):
  orig[index] = orig[index]
  i = 2
  while orig[index]*i <= orig[-1]:
    if (orig[index]*i) in orig:
      orig.remove(orig[index]*i)
    i+=1
  index += 1
print orig
