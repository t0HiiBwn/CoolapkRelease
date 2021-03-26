package com.coolapk.market.util;

public class PatchUtils {
    public static native int patch(String str, String str2, String str3);

    static {
        System.loadLibrary("ApkPatch");
    }
}
