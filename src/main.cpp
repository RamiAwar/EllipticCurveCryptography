#include <iostream>
#include <Curves.h>
#include <KeyGen.h>

int main() {
	EccCalculator* eccCalculator = new EccCalculator(secp192k1);
	KeyGen* keyGen = new KeyGen(eccCalculator);
	keyGen->GenerateKeyPair();	

	Point pubKey = keyGen->GetPublicKey();
	cpp_int privKey = keyGen->GetPrivateKey();
	std::cout << "Private key: " << privKey << std::endl;
	std::cout << "Public key: " << pubKey << std::endl;
	return 0;
}
