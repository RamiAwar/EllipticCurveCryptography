#pragma once

#include <boost/multiprecision/cpp_int.hpp>
#include <assert.h>

using namespace boost::multiprecision;

/**
 * Returns the multiplicative inverse of k mod p
 *
 */
cpp_int InverseMod(cpp_int k, cpp_int p){

	if (k == 0) {
        throw "Division by zero error";
    }

    if (k < 0) {
        return p - InverseMod(-k, p);
    }

    cpp_int s = 0;
    cpp_int prev_s = 1;
    cpp_int t = 1;
    cpp_int prev_t = 0;
    cpp_int r = p;
    cpp_int prev_r = k;

    cpp_int quotient = 0;
    cpp_int temp = 0;

    while (r != 0) {
        quotient = prev_r / r;

        temp = prev_r;
        prev_r = r;
        r = temp - quotient * r;

        temp = prev_s;
        prev_s = s;
        s = temp - quotient * s;

        temp = prev_t;
        prev_t = t;
        t = temp - quotient * t;
    }

    cpp_int gcd = prev_r;
    cpp_int x = prev_s;
    cpp_int y = prev_t;

    return x % p;
}
