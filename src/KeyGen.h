#include <EccCalculator.h>
#include <boost/random.hpp>

using namespace boost::random;

class KeyGen {
   private:
    cpp_int privateKey;
    std::unique_ptr<const Point> publicKey;

   public:
    EccCalculator* eccCalculator;
    KeyGen(EccCalculator* eccCalculator) {
        this->eccCalculator = eccCalculator;
    }

    void GenerateKeyPair() {
        mt19937 mt;
        uniform_int_distribution<cpp_int> ui(0, eccCalculator->curve.n);
        mt.seed(std::time(0));

        privateKey = ui(mt);

        const Point ret_val = eccCalculator->scalarMult(privateKey, eccCalculator->curve.g);

        publicKey.reset(new Point(ret_val));
    }

    Point GetPublicKey() const { return *publicKey; }

    cpp_int GetPrivateKey() const { return privateKey; }
};