package com.ecc.ecc;


/**
 * Created by ramiawar on 12/5/18.
 */
public class EccWrapper {

    static {
        System.loadLibrary("ECC"); // Load native library hello.dll (Windows) or libhello.so (Unixes)
                                            //  at runtime
                                            // This library contains a native method called sayHello()
    }

    // Declare an instance native method sayHello() which receives no parameter and returns void
    private native void generateKeyPair();

    // Test Driver
    public static void generate() {
//        System.out.println(System.getProperty("java.library.path"));
        new EccWrapper().generateKeyPair();  // Create an instance and invoke the native method

    }

}