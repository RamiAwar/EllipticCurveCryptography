/**
 * Created by ramiawar on 12/5/18.
 */
public class EccWrapper {

    static {
        System.loadLibrary("ECC"); // Load native library hello.dll (Windows) or libhello.so (Unixes)
                                            //  at runtime
                                            // This library contains a native method called sayHello()
        System.out.println("Library loaded");
    }

    // Declare an instance native method sayHello() which receives no parameter and returns void
    private native String generateKeyPair();

    // Test Driver
    public static void main(String[] args) {
//        System.out.println(System.getProperty("java.library.path"));
        System.out.println(new EccWrapper().generateKeyPair());  // Create an instance and invoke the native method

    }

}