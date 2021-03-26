package com.tencent.android.tpush.stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.stat.a.b;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import org.apache.http.HttpHost;

/* compiled from: ProGuard */
public class a {
    private static volatile a a;
    private volatile int b = 2;
    private volatile String c = "";
    private volatile HttpHost d = null;
    private Context e = null;
    private b f = null;

    private a(Context context) {
        this.e = context.getApplicationContext();
        d.a(context);
        this.f = com.tencent.android.tpush.stat.a.a.b();
        d();
        b();
    }

    public boolean a() {
        return this.b != 0;
    }

    public static a a(Context context) {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a(context);
                }
            }
        }
        return a;
    }

    private void d() {
        this.b = 0;
        this.d = null;
        this.c = null;
    }

    void b() {
        if (DeviceInfos.isNetworkAvailable(this.e)) {
            this.c = DeviceInfos.getLinkedWay(this.e);
            if (b.b()) {
                b bVar = this.f;
                bVar.b("NETWORK name:" + this.c);
            }
            if (com.tencent.android.tpush.stat.a.a.b(this.c)) {
                if ("WIFI".equalsIgnoreCase(this.c)) {
                    this.b = 1;
                } else {
                    this.b = 2;
                }
                this.d = com.tencent.android.tpush.stat.a.a.b(this.e);
                return;
            }
            return;
        }
        if (b.b()) {
            this.f.b("NETWORK TYPE: network is close.");
        }
        d();
    }

    public void c() {
        try {
            this.e.getApplicationContext().registerReceiver(new BroadcastReceiver() {
                /* class com.tencent.android.tpush.stat.a.AnonymousClass1 */

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    CommonWorkingThread.getInstance().execute(new Runnable() {
                        /* class com.tencent.android.tpush.stat.a.AnonymousClass1.AnonymousClass1 */

                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.b();
                        }
                    });
                }
            }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Throwable th) {
            TLogger.e("registerBroadcast", "", th);
        }
    }
}
