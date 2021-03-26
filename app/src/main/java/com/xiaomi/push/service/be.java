package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ab;
import com.xiaomi.push.l;
import java.util.ArrayList;
import java.util.List;

public class be {
    private static be a;

    /* renamed from: a  reason: collision with other field name */
    private static String f986a;

    /* renamed from: a  reason: collision with other field name */
    private Context f987a;

    /* renamed from: a  reason: collision with other field name */
    private Messenger f988a;

    /* renamed from: a  reason: collision with other field name */
    private List<Message> f989a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    private boolean f990a = false;
    private Messenger b;

    /* renamed from: b  reason: collision with other field name */
    private boolean f991b = false;

    private be(Context context) {
        this.f987a = context.getApplicationContext();
        this.f988a = new Messenger(new bf(this, Looper.getMainLooper()));
        if (a()) {
            b.c("use miui push service");
            this.f990a = true;
        }
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    public static be a(Context context) {
        if (a == null) {
            a = new be(context);
        }
        return a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private synchronized void m639a(Intent intent) {
        if (this.f991b) {
            Message a2 = a(intent);
            if (this.f989a.size() >= 50) {
                this.f989a.remove(0);
            }
            this.f989a.add(a2);
            return;
        }
        if (this.b == null) {
            this.f987a.bindService(intent, new bg(this), 1);
            this.f991b = true;
            this.f989a.clear();
            this.f989a.add(a(intent));
        } else {
            try {
                this.b.send(a(intent));
            } catch (RemoteException unused) {
                this.b = null;
                this.f991b = false;
            }
        }
    }

    private boolean a() {
        if (ab.e) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.f987a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            return packageInfo != null && packageInfo.versionCode >= 104;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m640a(Intent intent) {
        try {
            if (l.m568a() || Build.VERSION.SDK_INT < 26) {
                this.f987a.startService(intent);
                return true;
            }
            m639a(intent);
            return true;
        } catch (Exception e) {
            b.a(e);
            return false;
        }
    }
}
