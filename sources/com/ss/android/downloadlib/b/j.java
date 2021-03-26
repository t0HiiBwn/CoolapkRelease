package com.ss.android.downloadlib.b;

import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.downloadlib.h.k;

/* compiled from: MarketUriUtils */
public class j {
    public static boolean a(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            return false;
        }
        if ("market".equals(scheme) || "appmarket".equals(scheme) || "oaps".equals(scheme) || "oppomarket".equals(scheme) || "mimarket".equals(scheme) || "vivomarket".equals(scheme) || "vivoMarket".equals(scheme) || "gomarket".equals(scheme) || "goMarket".equals(scheme) || "mstore".equals(scheme) || "samsungapps".equals(scheme)) {
            return true;
        }
        return false;
    }

    public static String b(Uri uri) {
        return k.a(uri.getQueryParameter("id"), uri.getQueryParameter("packagename"), uri.getQueryParameter("pkg"), uri.getQueryParameter("package_name"), uri.getQueryParameter("appId"));
    }
}
