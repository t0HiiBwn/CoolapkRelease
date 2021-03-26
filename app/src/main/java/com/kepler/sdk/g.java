package com.kepler.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.List;

public class g {
    public static final List<String> a;

    static final class a {
        private static g a = new g();
    }

    private g() {
    }

    public static final g a() {
        return a.a;
    }

    static {
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add("kepler=\"\"");
        arrayList.add("os=\"\"");
        arrayList.add("osversion=\"\"");
        arrayList.add("version=\"\"");
        arrayList.add("appversion=\"\"");
        arrayList.add("token=\"\"");
    }

    public void a(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("auth_shared", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public void a(Context context, String str, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences("auth_shared", 0).edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public String a(Context context, String str) {
        return context.getSharedPreferences("auth_shared", 0).getString(str, "");
    }
}
