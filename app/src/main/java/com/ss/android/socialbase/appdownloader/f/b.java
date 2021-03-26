package com.ss.android.socialbase.appdownloader.f;

import android.text.TextUtils;
import android.util.Base64;
import com.ss.android.socialbase.downloader.i.e;
import org.json.JSONObject;

/* compiled from: DecryptUtils */
public class b {
    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        byte[] decode = Base64.decode(e.a(str), 0);
        int length = str2.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (byte b : decode) {
            if (i >= length) {
                i %= length;
            }
            sb.append((char) (b ^ str2.charAt(i)));
            i++;
        }
        return sb.toString();
    }

    public static String a(JSONObject jSONObject, String str, String str2) {
        return a(jSONObject.optString(str), str2);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new String(Base64.decode(e.a(str), 0));
    }
}
