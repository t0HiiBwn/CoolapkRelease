package com.bun.miitmdid.provider.nubia;

import android.content.Context;
import android.net.Uri;
import com.netease.nis.sdkwrapper.Utils;

public class NubiaIdentityImpl {
    private static final String TAG = "NubiaLog";
    private static Uri uri = Uri.parse("content://cn.nubia.identity/identity");

    public static String getAAID(Context context, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = context;
        objArr[2] = str;
        objArr[3] = 75;
        objArr[4] = 1606976968547L;
        return (String) Utils.rL(objArr);
    }

    public static String getOAID(Context context) {
        Object[] objArr = new Object[4];
        objArr[1] = context;
        objArr[2] = 76;
        objArr[3] = 1606976968548L;
        return (String) Utils.rL(objArr);
    }

    public static String getVAID(Context context, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = context;
        objArr[2] = str;
        objArr[3] = 77;
        objArr[4] = 1606976968549L;
        return (String) Utils.rL(objArr);
    }

    public static boolean isSupported(Context context) {
        Object[] objArr = new Object[4];
        objArr[1] = context;
        objArr[2] = 78;
        objArr[3] = 1606976968550L;
        return ((Boolean) Utils.rL(objArr)).booleanValue();
    }
}
