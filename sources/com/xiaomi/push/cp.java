package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.j;
import com.xiaomi.push.service.l;

public class cp {
    private static volatile cp a;
    private Context b;

    private cp(Context context) {
        this.b = context;
    }

    private int a(int i) {
        return Math.max(60, i);
    }

    public static cp a(Context context) {
        if (a == null) {
            synchronized (cp.class) {
                if (a == null) {
                    a = new cp(context);
                }
            }
        }
        return a;
    }

    private void a(l lVar, j jVar, boolean z) {
        if (lVar.a(gn.UploadSwitch.a(), true)) {
            db dbVar = new db(this.b);
            if (z) {
                jVar.a((j.a) dbVar, a(lVar.a(gn.UploadFrequency.a(), 86400)));
            } else {
                jVar.a((j.a) dbVar);
            }
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        j a2 = j.a(this.b);
        l a3 = l.a(this.b);
        SharedPreferences sharedPreferences = this.b.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        long j = sharedPreferences.getLong("first_try_ts", currentTimeMillis);
        if (j == currentTimeMillis) {
            sharedPreferences.edit().putLong("first_try_ts", currentTimeMillis).commit();
        }
        if (Math.abs(currentTimeMillis - j) >= 172800000) {
            a(a3, a2, false);
            if (a3.a(gn.StorageCollectionSwitch.a(), true)) {
                int a4 = a(a3.a(gn.StorageCollectionFrequency.a(), 86400));
                a2.a(new cz(this.b, a4), a4, 0);
            }
            boolean a5 = a3.a(gn.AppIsInstalledCollectionSwitch.a(), false);
            String a6 = a3.a(gn.AppIsInstalledList.a(), (String) null);
            if (a5 && !TextUtils.isEmpty(a6)) {
                int a7 = a(a3.a(gn.AppIsInstalledCollectionFrequency.a(), 86400));
                a2.a(new ct(this.b, a7, a6), a7, 0);
            }
            boolean a8 = a3.a(gn.ScreenSizeCollectionSwitch.a(), true);
            boolean a9 = a3.a(gn.AndroidVnCollectionSwitch.a(), true);
            boolean a10 = a3.a(gn.AndroidVcCollectionSwitch.a(), true);
            boolean a11 = a3.a(gn.AndroidIdCollectionSwitch.a(), true);
            boolean a12 = a3.a(gn.OperatorSwitch.a(), true);
            if (a8 || a9 || a10 || a11 || a12) {
                int a13 = a(a3.a(gn.DeviceInfoCollectionFrequency.a(), 1209600));
                a2.a(new cy(this.b, a13, a8, a9, a10, a11, a12), a13, 0);
            }
            boolean a14 = a3.a(gn.MacCollectionSwitch.a(), false);
            boolean a15 = a3.a(gn.IMSICollectionSwitch.a(), false);
            boolean a16 = a3.a(gn.IccidCollectionSwitch.a(), false);
            boolean a17 = a3.a(gn.DeviceIdSwitch.a(), false);
            if (a14 || a15 || a16 || a17) {
                int a18 = a(a3.a(gn.DeviceBaseInfoCollectionFrequency.a(), 1209600));
                a2.a(new cx(this.b, a18, a14, a15, a16, a17), a18, 0);
            }
            if (Build.VERSION.SDK_INT < 21 && a3.a(gn.AppActiveListCollectionSwitch.a(), false)) {
                int a19 = a(a3.a(gn.AppActiveListCollectionFrequency.a(), 900));
                a2.a(new cr(this.b, a19), a19, 0);
            }
            if (a3.a(gn.TopAppCollectionSwitch.a(), false)) {
                int a20 = a(a3.a(gn.TopAppCollectionFrequency.a(), 300));
                a2.a(new da(this.b, a20), a20, 0);
            }
            if (a3.a(gn.BroadcastActionCollectionSwitch.a(), true)) {
                int a21 = a(a3.a(gn.BroadcastActionCollectionFrequency.a(), 900));
                a2.a(new cv(this.b, a21), a21, 0);
            }
            if (a3.a(gn.ActivityTSSwitch.a(), false)) {
                c();
            }
            if (a3.a(gn.BatteryCollectionSwitch.a(), false)) {
                int a22 = a(a3.a(gn.BatteryCollectionFrequency.a(), 3600));
                a2.a(new cu(this.b, a22), a22, 0);
            }
            a(a3, a2, true);
        }
    }

    private boolean c() {
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                Context context = this.b;
                if (!(context instanceof Application)) {
                    context = context.getApplicationContext();
                }
                ((Application) context).registerActivityLifecycleCallbacks(new cg(this.b, String.valueOf(System.currentTimeMillis() / 1000)));
                return true;
            } catch (Exception e) {
                c.a(e);
            }
        }
        return false;
    }

    public void a() {
        j.a(this.b).a(new cq(this));
    }
}
