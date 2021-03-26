package com.xiaomi.push.service;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import com.xiaomi.push.ab;

public class az {
    private static az a;

    /* renamed from: a  reason: collision with other field name */
    private int f978a = 0;

    /* renamed from: a  reason: collision with other field name */
    private Context f979a;

    private az(Context context) {
        this.f979a = context.getApplicationContext();
    }

    public static az a(Context context) {
        if (a == null) {
            a = new az(context);
        }
        return a;
    }

    public int a() {
        int i = this.f978a;
        if (i != 0) {
            return i;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                this.f978a = Settings.Global.getInt(this.f979a.getContentResolver(), "device_provisioned", 0);
            } catch (Exception unused) {
            }
            return this.f978a;
        }
        int i2 = Settings.Secure.getInt(this.f979a.getContentResolver(), "device_provisioned", 0);
        this.f978a = i2;
        return i2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Uri m634a() {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getUriFor("device_provisioned") : Settings.Secure.getUriFor("device_provisioned");
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m635a() {
        return ab.f183a.contains("xmsf") || ab.f183a.contains("xiaomi") || ab.f183a.contains("miui");
    }
}
