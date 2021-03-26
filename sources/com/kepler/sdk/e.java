package com.kepler.sdk;

import android.content.Context;

public class e {
    private String a;
    private String b;
    private String c;
    private boolean d;

    static class a {
        private static final e a = new e();
    }

    private e() {
        this.d = false;
    }

    public static final e a() {
        return a.a;
    }

    public void a(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public boolean a(Context context) {
        boolean a2 = new z().a(context, c());
        this.d = a2;
        return a2;
    }

    private String c() {
        return this.b;
    }

    public String b() {
        return this.b;
    }
}
