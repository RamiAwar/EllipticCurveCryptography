#pragma once

#include <boost/multiprecision/cpp_int.hpp>
#include <string>

using namespace boost::multiprecision;

struct Point {
    const cpp_int x;
    const cpp_int y;
	Point() : x(0), y(0) {}
	Point(const std::string& _x, const std::string& _y) : x(_x), y(_y) {}
	Point(const cpp_int& _x, const cpp_int& _y) : x(_x), y(_y) {}
	Point(const Point & p) : x(p.x), y(p.y) {}
	bool operator==(const Point& rhs) const { return x == rhs.x && y == rhs.y; }

    friend std::ostream & operator<<(std::ostream& os, const Point& p);
};

std::ostream& operator<<(std::ostream& os, const Point& p) {
    os << "(" << p.x << ", " << p.y << ")";
    return os;
}

const Point pointAtInfinity(-1, -1);

class EllipticCurve {
   public:
    const cpp_int p;  // Finite field
    const cpp_int a;  // Elliptic Curve parameter 1
    const cpp_int b;  // Elliptic Curve parameter 2

    const Point g;  // Generator point

    const cpp_int n;  //Subgroup order
    const cpp_int h;  //Subgroup cofactor

    //Constructor
    EllipticCurve(const std::string& _p, const std::string& _a, const std::string& _b,
                  const Point& _g, const std::string& _n, const std::string& _h)
        : p(_p), a(_a), b(_b), g(_g), n(_n), h(_h) {}

    // Copy Constructor
    EllipticCurve(const EllipticCurve& c)
        : p(c.p), a(c.a), g(c.g), b(c.b), n(c.n), h(c.h) {}
};
