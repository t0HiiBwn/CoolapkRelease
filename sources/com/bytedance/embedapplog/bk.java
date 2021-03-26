package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

public class bk {
    private static volatile String a;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0042  */
    public static String a(Context context, z zVar) {
        String str;
        if (TextUtils.isEmpty(a)) {
            synchronized (bk.class) {
                if (!TextUtils.isEmpty(a)) {
                    return a;
                }
                try {
                    AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                    if (advertisingIdInfo != null) {
                        str = advertisingIdInfo.getId();
                        if (!TextUtils.isEmpty(str)) {
                            str = zVar.e().getString("google_aid", null);
                        } else if (!TextUtils.equals(zVar.e().getString("google_aid", null), str)) {
                            a(context, str, zVar);
                        }
                        a = str;
                    }
                } catch (Throwable th) {
                    if (!(th instanceof ClassNotFoundException) && !(th instanceof NoClassDefFoundError)) {
                        th.printStackTrace();
                    }
                }
                str = null;
                if (!TextUtils.isEmpty(str)) {
                }
                a = str;
            }
        }
        return a;
    }

    private static void a(Context context, String str, z zVar) {
        if (!TextUtils.isEmpty(str) && context != null) {
            zVar.e().edit().putString("google_aid", str).apply();
        }
    }
}
