package com.ss.android.downloadlib.a.b;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.k;

/* compiled from: DeviceUtils */
public class b {
    public static String a(Context context) {
        try {
            return a(c.a(a(), "MD5"));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a() {
        return b(k.a());
    }

    public static String b(Context context) {
        String str;
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static String a(byte[] bArr) {
        return a.a(bArr);
    }
}
