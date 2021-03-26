package com.huawei.updatesdk.a.b.c;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public final class b {
    private Intent a;

    private b(Intent intent) {
        this.a = intent;
    }

    public static b a(Intent intent) {
        return new b(intent);
    }

    public long a(String str, int i) {
        if (d()) {
            try {
                return this.a.getLongExtra(str, (long) i);
            } catch (Exception unused) {
                Log.e("SecureIntent", "getIntExtra exception!");
            }
        }
        return (long) i;
    }

    public Bundle a() {
        if (d()) {
            return this.a.getExtras();
        }
        return null;
    }

    public String a(String str) {
        if (!d()) {
            return "";
        }
        try {
            return this.a.getStringExtra(str);
        } catch (Exception unused) {
            Log.e("SecureIntent", "getStringExtra exception!");
            return "";
        }
    }

    public boolean a(String str, boolean z) {
        if (d()) {
            try {
                return this.a.getBooleanExtra(str, z);
            } catch (Exception unused) {
                Log.e("SecureIntent", "getBooleanExtra exception!");
            }
        }
        return z;
    }

    public int b(String str, int i) {
        if (d()) {
            try {
                return this.a.getIntExtra(str, i);
            } catch (Exception unused) {
                Log.e("SecureIntent", "getIntExtra exception!");
            }
        }
        return i;
    }

    public String b() {
        String action;
        return (!d() || (action = this.a.getAction()) == null) ? "" : action;
    }

    public Intent c() {
        return this.a;
    }

    public boolean d() {
        return this.a != null;
    }
}
