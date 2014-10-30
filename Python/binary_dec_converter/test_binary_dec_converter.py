__author__ = 'lew'

import unittest
import random
from binary_dec_converter import to_binary, to_decimal

class TestBinaryDecConverted(unittest.TestCase):
    def setUp(self):
        self.random_numbers = []
        for i in range(100):
            self.random_numbers.append(random.randint(1,1000000000000))

    def test_works_like_bin(self):
        for random_number in self.random_numbers:
            self.assertEqual(bin(random_number), to_binary(random_number))

    def test_identity(self):
        for random_number in self.random_numbers:
            self.assertEqual(random_number, to_decimal(to_binary(random_number)))

if __name__ == '__main__':
    unittest.main()
