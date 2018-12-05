#include <EllipticCurve.h>

EllipticCurve secp192k1(
    "0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFEE37",
	"0x0",
	"0x3",
	Point("0xDB4FF10EC057E9AE26B07D0280B7F4341DA5D1B1EAE06C7D",
		"0x9B2F2F6D9C5628A7844163D015BE86344082AA88D95E2F9D"
	),
	"0xFFFFFFFFFFFFFFFFFFFFFFFE26F2FC170F69466A74DEFD8D",
	"0x1");

EllipticCurve secp256k1(
    "0xfffffffffffffffffffffffffffffffffffffffffffffffffffffffefffffc2f",
    "0x0",
    "0x7",
    Point("0x79be667ef9dcbbac55a06295ce870b07029bfcdb2dce28d959f2815b16f81798",
          "0x483ada7726a3c4655da4fbfc0e1108a8fd17b448a68554199c47d08ffb10d4b8"),
    "0xfffffffffffffffffffffffffffffffebaaedce6af48a03bbfd25e8cd0364141",
    "0x1");
