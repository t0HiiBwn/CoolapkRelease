package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.it;
import java.util.ArrayList;
import java.util.List;

public class ad {
    private static ad a;
    private static String e;
    private Context b;
    private Messenger c;
    private boolean d = false;
    private List<Message> f = new ArrayList();
    private boolean g = false;
    private Messenger h;

    private ad(Context context) {
        this.b = context.getApplicationContext();
        this.c = new Messenger(new ae(this, Looper.getMainLooper()));
        if (a()) {
            c.c("use miui push service");
            this.d = true;
        }
    }

    public static ad a(Context context) {
        if (a == null) {
            a = new ad(context);
        }
        return a;
    }

    private boolean a() {
        if (com.xiaomi.push.c.f) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.b.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            return packageInfo != null && packageInfo.versionCode >= 104;
        } catch (Exception unused) {
            return false;
        }
    }

    private synchronized void b(Intent intent) {
        if (this.g) {
            Message c2 = c(intent);
            if (this.f.size() >= 50) {
                this.f.remove(0);
            }
            this.f.add(c2);
            return;
        }
        if (this.h == null) {
            this.b.bindService(intent, new af(this), 1);
            this.g = true;
            this.f.clear();
            this.f.add(c(intent));
        } else {
            try {
                this.h.send(c(intent));
            } catch (RemoteException unused) {
                this.h = null;
                this.g = false;
            }
        }
    }

    private Message c(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    public boolean a(Intent intent) {
        try {
            if (it.a() || Build.VERSION.SDK_INT < 26) {
                this.b.startService(intent);
                return true;
            }
            b(intent);
            return true;
        } catch (Exception e2) {
            c.a(e2);
            return false;
        }
    }
}
