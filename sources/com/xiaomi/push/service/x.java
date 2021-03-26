package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import com.xiaomi.push.c;

public class x {
    private static x a;
    private Context b;
    private int c = 0;

    private x(Context context) {
        this.b = context.getApplicationContext();
    }

    public static x a(Context context) {
        if (a == null) {
            a = new x(context);
        }
        return a;
    }

    public boolean a() {
        return c.a.contains("xmsf") || c.a.contains("xiaomi") || c.a.contains("miui");
    }

    public int b() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                this.c = Settings.Global.getInt(this.b.getContentResolver(), "device_provisioned", 0);
            } catch (Exception unused) {
            }
            return this.c;
        }
        int i2 = Settings.Secure.getInt(this.b.getContentResolver(), "device_provisioned", 0);
        this.c = i2;
        return i2;
    }

    public Uri c() {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getUriFor("device_provisioned") : Settings.Secure.getUriFor("device_provisioned");
    }
}
