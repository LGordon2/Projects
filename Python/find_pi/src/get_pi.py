__author__ = 'lew'

from decimal import *
import sys

ACCURACY = 10

def get_pi(n):
    if n < 0 and not n:
        raise ValueError, "n is invalid"
    n += 1
    getcontext().prec = n

    if n > 93:
        raise Exception('Precision cannot be greater than 92.')

    sum = 0
    for i in range(ACCURACY):
        sum += Decimal((4.0/(8.0*i+1)-2.0/(8.0*i+4)-1.0/(8.0*i+5)-1.0/(8.0*i+6))*(1.0/16.0)**i)
    return sum

def main():
    if len(sys.argv) < 2:
        print 'Decimal places required!'
        exit(1)

    print get_pi(int(sys.argv[1]))

if __name__ == '__main__':
    main()