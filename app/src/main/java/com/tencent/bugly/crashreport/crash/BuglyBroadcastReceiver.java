package com.tencent.bugly.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.crashreport.common.info.b;
import com.tencent.bugly.crashreport.common.strategy.a;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;

/* compiled from: BUGLY */
public class BuglyBroadcastReceiver extends BroadcastReceiver {
    private static BuglyBroadcastReceiver d;
    private IntentFilter a = new IntentFilter();
    private Context b;
    private String c;
    private boolean e = true;

    public static synchronized BuglyBroadcastReceiver getInstance() {
        BuglyBroadcastReceiver buglyBroadcastReceiver;
        synchronized (BuglyBroadcastReceiver.class) {
            if (d == null) {
                d = new BuglyBroadcastReceiver();
            }
            buglyBroadcastReceiver = d;
        }
        return buglyBroadcastReceiver;
    }

    public synchronized void addFilter(String str) {
        if (!this.a.hasAction(str)) {
            this.a.addAction(str);
        }
        x.c("add action %s", str);
    }

    public synchronized void register(Context context) {
        this.b = context;
        z.a(new Runnable() {
            /* class com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver.AnonymousClass1 */

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    x.a(BuglyBroadcastReceiver.d.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                    synchronized (this) {
                        BuglyBroadcastReceiver.this.b.registerReceiver(BuglyBroadcastReceiver.d, BuglyBroadcastReceiver.this.a, "com.tencent.bugly.BuglyBroadcastReceiver.permission", null);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public synchronized void unregister(Context context) {
        try {
            x.a(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.b = context;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
        }
    }

    private synchronized boolean a(Context context, Intent intent) {
        if (!(context == null || intent == null)) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.e) {
                    this.e = false;
                    return true;
                }
                String b2 = b.b(this.b);
                x.c("is Connect BC " + b2, new Object[0]);
                x.a("network %s changed to %s", this.c, b2);
                if (b2 == null) {
                    this.c = null;
                    return true;
                }
                String str = this.c;
                this.c = b2;
                long currentTimeMillis = System.currentTimeMillis();
                a a2 = a.a();
                u a3 = u.a();
                com.tencent.bugly.crashreport.common.info.a a4 = com.tencent.bugly.crashreport.common.info.a.a(context);
                if (a2 == null || a3 == null || a4 == null) {
                    x.d("not inited BC not work", new Object[0]);
                    return true;
                }
                if (!b2.equals(str)) {
                    if (currentTimeMillis - a3.a(c.a) > 30000) {
                        x.a("try to upload crash on network changed.", new Object[0]);
                        c a5 = c.a();
                        if (a5 != null) {
                            a5.a(0L);
                        }
                    }
                    if (currentTimeMillis - a3.a(1001) > 30000) {
                        x.a("try to upload userinfo on network changed.", new Object[0]);
                        com.tencent.bugly.crashreport.biz.b.a.b();
                    }
                }
                return true;
            }
        }
        return false;
    }
}
