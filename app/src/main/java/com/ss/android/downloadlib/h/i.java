package com.ss.android.downloadlib.h;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.k;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: PermissionUtils */
public class i {
    private static Map<String, a> a = Collections.synchronizedMap(new HashMap());

    /* compiled from: PermissionUtils */
    public interface a {
        void a();

        void a(String str);
    }

    public static void a(String[] strArr, a aVar) {
        if (strArr != null && strArr.length > 0) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            a(valueOf, aVar);
            TTDelegateActivity.a(valueOf, strArr);
        }
    }

    public static void a(String str) {
        a c;
        if (!TextUtils.isEmpty(str) && (c = c(str)) != null) {
            c.a();
        }
    }

    public static void a(String str, String str2) {
        a c;
        if (!TextUtils.isEmpty(str) && (c = c(str)) != null) {
            c.a(str2);
        }
    }

    private static void a(String str, a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            a.put(str, aVar);
        }
    }

    private static a c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return a.remove(str);
    }

    public static boolean b(String str) {
        return k.f().a(k.a(), str);
    }
}
