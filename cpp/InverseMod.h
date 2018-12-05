#pragma once

#include <boost/multiprecision/cpp_int.hpp>

using namespace boost::multiprecision;

/**
 * Returns the multiplicative inverse of k mod p
 *
 */
cpp_int InverseMod(cpp_int k, cpp_int p);
