// Save as "HelloJNI.c"
#include <jni.h>        // JNI header provided by JDK
#include "EccWrapper.h"   // Generated
#include <iostream>
#include <Curves.h>
#include <KeyGen.h>
#include <string>


// Implementation of the native method sayHello()
JNIEXPORT jstring JNICALL Java_EccWrapper_generateKeyPair(JNIEnv * env, jobject){

	EccCalculator* eccCalculator = new EccCalculator(secp192k1);
	KeyGen* keyGen = new KeyGen(eccCalculator);
	keyGen->GenerateKeyPair();	

    jstring jstr;

	Point pubKey = keyGen->GetPublicKey();
	cpp_int privKey = keyGen->GetPrivateKey();


	std::string privateKey = boost::lexical_cast<std::string>(privKey);
    std::string publicKey = "(" + boost::lexical_cast<std::string>(pubKey.x) + "," + boost::lexical_cast<std::string>(pubKey.y) + ")";
    std::string result = privateKey + "_" + publicKey;

    char output[2080];
    strcpy(output, result.c_str());

    jstr = (*env).NewStringUTF(output);
	return jstr;

}