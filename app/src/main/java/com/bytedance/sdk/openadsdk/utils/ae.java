package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: SPUtils */
public class ae {
    private static Map<String, ae> a = new HashMap();
    private SharedPreferences b;

    public static ae a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_sp";
        }
        ae aeVar = a.get(str);
        if (aeVar != null) {
            return aeVar;
        }
        ae aeVar2 = new ae(str, context);
        a.put(str, aeVar2);
        return aeVar2;
    }

    private ae(String str, Context context) {
        if (context != null) {
            this.b = context.getApplicationContext().getSharedPreferences(str, 0);
        }
    }

    public void a(String str, String str2) {
        try {
            this.b.edit().putString(str, str2).apply();
        } catch (Throwable unused) {
        }
    }

    public String a(String str) {
        try {
            return b(str, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    public String b(String str, String str2) {
        try {
            return this.b.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public void a(String str, int i) {
        try {
            this.b.edit().putInt(str, i).apply();
        } catch (Throwable unused) {
        }
    }

    public int b(String str, int i) {
        try {
            return this.b.getInt(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    public void a(String str, long j) {
        try {
            this.b.edit().putLong(str, j).apply();
        } catch (Throwable unused) {
        }
    }

    public long b(String str, long j) {
        try {
            return this.b.getLong(str, j);
        } catch (Throwable unused) {
            return j;
        }
    }

    public void a(String str, boolean z) {
        try {
            this.b.edit().putBoolean(str, z).apply();
        } catch (Throwable unused) {
        }
    }

    public boolean b(String str, boolean z) {
        try {
            return this.b.getBoolean(str, z);
        } catch (Throwable unused) {
            return z;
        }
    }

    public void a(String str, Set<String> set) {
        try {
            this.b.edit().putStringSet(str, set).apply();
        } catch (Throwable unused) {
        }
    }

    public Set<String> b(String str, Set<String> set) {
        try {
            return this.b.getStringSet(str, set);
        } catch (Throwable unused) {
            return set;
        }
    }

    public void b(String str) {
        try {
            this.b.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }
}
