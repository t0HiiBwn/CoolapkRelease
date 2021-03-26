package com.umeng.umzid;

public class Spy {
    private static boolean initSuccess = true;

    public static native String getNativeID();

    public static native String getNativeLibraryVersion();

    static {
        try {
            System.loadLibrary("umeng-spy");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String getID() {
        if (initSuccess) {
            return getNativeID();
        }
        return null;
    }

    public static String getVersion() {
        if (initSuccess) {
            return getNativeLibraryVersion();
        }
        return null;
    }
}
