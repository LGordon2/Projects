__author__ = 'lew'

import unittest
import find_pi.get_pi

class TestFindPi(unittest.TestCase):
    def test_valid(self):
        for i in range(1, 93):
            precision = i
            _, decimal = str(find_pi.get_pi.get_pi(precision)).split(".")
            self.assertEqual(precision, len(decimal))

    def test_out_of_range(self):
        with self.assertRaises(Exception):
            precision = 93
            _, decimal = str(find_pi.get_pi.get_pi(precision)).split(".")

    def test_zero(self):
        precision = 0
        value = find_pi.get_pi.get_pi(precision)
        self.assertEqual(value, 3)

    def test_negative_precision(self):
        with self.assertRaises(ValueError):
            precision = -1
            value = find_pi.get_pi.get_pi(precision)

    def test_character_input(self):
        with self.assertRaises(Exception):
            precision = 'a'
            value = find_pi.get_pi.get_pi(precision)

    def test_none_input(self):
        with self.assertRaises(ValueError):
            precision = None
            value = find_pi.get_pi.get_pi(precision)
            self.assertEqual(value, 3)



if __name__ == '__main__':
    unittest.main()