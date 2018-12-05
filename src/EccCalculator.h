#pragma once

#include <EllipticCurve.h>
#include <InverseMod.h>

class EccCalculator {
   public:
    const EllipticCurve curve;

    EccCalculator(EllipticCurve& _curve) : curve(_curve) {}

    Point pointAdd(const Point& lhs, const Point & rhs) {
        if (lhs == pointAtInfinity) {
            return rhs;
        }

        if (rhs == pointAtInfinity) { 
            return lhs;
        }

        cpp_int x1 = lhs.x, y1 = lhs.y;
        cpp_int x2 = rhs.x, y2 = rhs.y;

        cpp_int m = 0;
        if (x1 == x2) {
            m = (3 * x1 * x1 + curve.a) * InverseMod(2 * y1, curve.p);
        } else {
            m = (y1 - y2) * InverseMod(x1 - x2, curve.p);
        }

        cpp_int x3 = m * m - x1 - x2;
        cpp_int y3 = y1 + m * (x3 - x1);

        return {x3 % curve.p, -y3 % curve.p};
    }

    Point scalarMult(cpp_int k, const Point& point) {
        if(k % curve.n == 0 || point == pointAtInfinity) {
            return pointAtInfinity;
        }

        if(k < 0) {
            Point negative = Neg(point);
            return scalarMult(-k, negative);
        }

        std::unique_ptr<const Point> result(new Point(pointAtInfinity));
        std::unique_ptr<const Point> addend(new Point(point));

        while(k) {
            if(k & 1) {
                const Point temp = pointAdd(*result, *addend);
                result.reset(new Point(temp));
            }
            const Point temp = pointAdd(*addend, *addend);
            addend.reset(new Point(temp));

            k >>= 1;
        }

        return *result;
    }

   private:
    bool IsOnCurve(Point& p) {
        if (p == pointAtInfinity) return true;
        cpp_int x = p.x;
        cpp_int y = p.y;
        return (y * y - x * x * x - curve.a * x - curve.b) % curve.p == 0;
    }

    Point Neg(const Point& p) {
        if (p == pointAtInfinity) return pointAtInfinity;
        return Point(p.x, -p.y % curve.p);
    }
};