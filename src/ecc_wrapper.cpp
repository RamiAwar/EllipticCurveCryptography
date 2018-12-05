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

	std::string privateKey = std::to_string(privKey);
	std::string publicKey = "(" + std::to_string(pubKey.x) + "," + std::to_string(pubKey.y) + ")";

    char greeting[] = "Hello, ";
    char output[] = privateKey + "_" + publicKey;

    jstr = (*env)->NewStringUTF(env, output);
	return jstr;
}