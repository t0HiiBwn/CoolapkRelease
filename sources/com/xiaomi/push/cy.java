package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class cy extends cw {
    private boolean a;
    private boolean b;
    private boolean e;
    private boolean f;
    private boolean g;

    public cy(Context context, int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        super(context, i);
        this.a = z;
        this.b = z2;
        this.e = z3;
        this.f = z4;
        this.g = z5;
    }

    private String f() {
        if (!this.a) {
            return "off";
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.d.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels + "," + displayMetrics.widthPixels;
        } catch (Throwable unused) {
            return "";
        }
    }

    private String g() {
        if (!this.b) {
            return "off";
        }
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable unused) {
            return "";
        }
    }

    private String h() {
        if (!this.e) {
            return "off";
        }
        try {
            return String.valueOf(Build.VERSION.SDK_INT);
        } catch (Throwable unused) {
            return "";
        }
    }

    private String i() {
        if (!this.f) {
            return "off";
        }
        try {
            return Settings.Secure.getString(this.d.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            return "";
        }
    }

    private String j() {
        if (!this.g) {
            return "off";
        }
        try {
            return ((TelephonyManager) this.d.getSystemService("phone")).getSimOperator();
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.xiaomi.push.j.a
    public int a() {
        return 3;
    }

    @Override // com.xiaomi.push.cw
    public String b() {
        return f() + "|" + g() + "|" + h() + "|" + i() + "|" + j();
    }

    @Override // com.xiaomi.push.cw
    public gk c() {
        return gk.DeviceInfoV2;
    }
}
