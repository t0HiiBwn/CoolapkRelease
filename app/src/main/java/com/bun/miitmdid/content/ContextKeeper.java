package com.bun.miitmdid.content;

import android.content.Context;
import com.netease.nis.sdkwrapper.Utils;

public class ContextKeeper {
    private static Context mContext;

    public static Context ReflectAppContext() {
        Object[] objArr = new Object[3];
        objArr[1] = 2;
        objArr[2] = 1606976968474L;
        return (Context) Utils.rL(objArr);
    }

    public static Context getAppContext() {
        Object[] objArr = new Object[3];
        objArr[1] = 3;
        objArr[2] = 1606976968475L;
        return (Context) Utils.rL(objArr);
    }

    public static Context getApplicationContext() {
        Object[] objArr = new Object[3];
        objArr[1] = 4;
        objArr[2] = 1606976968476L;
        return (Context) Utils.rL(objArr);
    }

    public static void init(Context context) {
        Object[] objArr = new Object[4];
        objArr[1] = context;
        objArr[2] = 5;
        objArr[3] = 1606976968477L;
        Utils.rL(objArr);
    }
}
