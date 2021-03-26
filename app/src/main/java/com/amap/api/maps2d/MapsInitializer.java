package com.amap.api.maps2d;

import android.content.Context;
import android.os.RemoteException;
import com.amap.api.mapcore2d.ar;
import com.amap.api.mapcore2d.cs;
import com.amap.api.mapcore2d.cw;
import com.amap.api.mapcore2d.q;

public final class MapsInitializer {
    public static final int HTTP = 1;
    public static final int HTTPS = 2;
    private static boolean a = true;
    private static boolean b = false;
    private static int c = 1;
    public static String sdcardDir = "";

    public static String getVersion() {
        return "6.0.0";
    }

    public static void initialize(Context context) throws RemoteException {
        if (context != null) {
            ar.a = context.getApplicationContext();
        }
    }

    public static void setNetworkEnable(boolean z) {
        a = z;
    }

    public static boolean getNetworkEnable() {
        return a;
    }

    public static void setApiKey(String str) {
        cs.a(str);
    }

    public static void replaceURL(String str, String str2) {
        if (str != null && !str.equals("")) {
            q.h = str;
            q.g = str2 + "DIY";
            if (str.contains("openstreetmap")) {
                q.c = 19;
            }
        }
    }

    public static void loadWorldGridMap(boolean z) {
        q.i = !z ? 1 : 0;
    }

    public static boolean getUpdateDataActiveEnable() {
        return b;
    }

    public static void setUpdateDataActiveEnable(boolean z) {
        b = z;
    }

    public static void setProtocol(int i) {
        c = i;
        cw.a().a(c == 2);
    }

    public static int getProtocol() {
        return c;
    }
}
