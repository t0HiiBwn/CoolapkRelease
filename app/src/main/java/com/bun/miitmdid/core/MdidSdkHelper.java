package com.bun.miitmdid.core;

import android.content.Context;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.netease.nis.sdkwrapper.Utils;

public class MdidSdkHelper {
    public static String TAG = "MdidSdkHelper";
    public static boolean _OuterIsOk = true;
    private String sdk_date = "20200702";

    public static int InitSdk(Context context, boolean z, IIdentifierListener iIdentifierListener) {
        Object[] objArr = new Object[6];
        objArr[1] = context;
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = iIdentifierListener;
        objArr[4] = 28;
        objArr[5] = 1606976968500L;
        return ((Integer) Utils.rL(objArr)).intValue();
    }

    public static void logd(boolean z, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = str;
        objArr[3] = 29;
        objArr[4] = 1606976968501L;
        Utils.rL(objArr);
    }

    public static void loge(boolean z, Exception exc) {
        Object[] objArr = new Object[5];
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = exc;
        objArr[3] = 30;
        objArr[4] = 1606976968502L;
        Utils.rL(objArr);
    }
}
