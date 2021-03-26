package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ai;
import com.xiaomi.push.service.an;

/* renamed from: com.xiaomi.push.do  reason: invalid class name */
public class Cdo {
    private static volatile Cdo a;

    /* renamed from: a  reason: collision with other field name */
    private Context f320a;

    private Cdo(Context context) {
        this.f320a = context;
    }

    private int a(int i) {
        return Math.max(60, i);
    }

    public static Cdo a(Context context) {
        if (a == null) {
            synchronized (Cdo.class) {
                if (a == null) {
                    a = new Cdo(context);
                }
            }
        }
        return a;
    }

    private void a(an anVar, ai aiVar, boolean z) {
        if (anVar.a(hh.UploadSwitch.a(), true)) {
            du duVar = new du(this.f320a);
            if (z) {
                aiVar.a((ai.a) duVar, a(anVar.a(hh.UploadFrequency.a(), 86400)));
            } else {
                aiVar.m102a((ai.a) duVar);
            }
        }
    }

    private boolean a() {
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                Context context = this.f320a;
                if (!(context instanceof Application)) {
                    context = context.getApplicationContext();
                }
                ((Application) context).registerActivityLifecycleCallbacks(new df(this.f320a, String.valueOf(System.currentTimeMillis() / 1000)));
                return true;
            } catch (Exception e) {
                b.a(e);
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void b() {
        ai a2 = ai.a(this.f320a);
        an a3 = an.a(this.f320a);
        SharedPreferences sharedPreferences = this.f320a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        long j = sharedPreferences.getLong("first_try_ts", currentTimeMillis);
        if (j == currentTimeMillis) {
            sharedPreferences.edit().putLong("first_try_ts", currentTimeMillis).commit();
        }
        if (Math.abs(currentTimeMillis - j) >= 172800000) {
            a(a3, a2, false);
            if (a3.a(hh.StorageCollectionSwitch.a(), true)) {
                int a4 = a(a3.a(hh.StorageCollectionFrequency.a(), 86400));
                a2.a(new dt(this.f320a, a4), a4, 0);
            }
            boolean a5 = a3.a(hh.AppIsInstalledCollectionSwitch.a(), false);
            String a6 = a3.a(hh.AppIsInstalledList.a(), (String) null);
            if (a5 && !TextUtils.isEmpty(a6)) {
                int a7 = a(a3.a(hh.AppIsInstalledCollectionFrequency.a(), 86400));
                a2.a(new dq(this.f320a, a7, a6), a7, 0);
            }
            if (a3.a(hh.BroadcastActionCollectionSwitch.a(), true)) {
                int a8 = a(a3.a(hh.BroadcastActionCollectionFrequency.a(), 900));
                a2.a(new dr(this.f320a, a8), a8, 0);
            }
            if (a3.a(hh.ActivityTSSwitch.a(), false)) {
                a();
            }
            a(a3, a2, true);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m201a() {
        ai.a(this.f320a).a(new dp(this));
    }
}
