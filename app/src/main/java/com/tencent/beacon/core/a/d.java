package com.tencent.beacon.core.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.beacon.core.a.b;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.event.TunnelModule;
import com.tencent.beacon.core.event.UserEventModule;
import com.tencent.beacon.core.strategy.StrategyQueryModule;

/* compiled from: ConnectChangeReceiver */
public final class d extends BroadcastReceiver implements Runnable {
    private boolean a = false;
    private Context b;
    private boolean c = false;
    private Runnable d = new Runnable() {
        /* class com.tencent.beacon.core.a.d.AnonymousClass1 */

        @Override // java.lang.Runnable
        public final void run() {
            b.b("[net] db events to up on netConnectChange", new Object[0]);
            try {
                TunnelModule.doUploadRecentCommonData(true);
            } catch (Throwable th) {
                b.a(th);
            }
        }
    };

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.b = context.getApplicationContext();
        if (!this.c) {
            b.a.a().a(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c = true;
        try {
            Context context = this.b;
            if (context == null) {
                com.tencent.beacon.core.d.b.d("[net] onReceive context is null!", new Object[0]);
                return;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                com.tencent.beacon.core.d.b.d("[net] onReceive ConnectivityManager is null!", new Object[0]);
                return;
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            NetworkInfo.State state = null;
            NetworkInfo.State state2 = networkInfo != null ? networkInfo.getState() : null;
            if (networkInfo2 != null) {
                state = networkInfo2.getState();
            }
            if (!(state2 == null && state == null)) {
                StrategyQueryModule instance = StrategyQueryModule.getInstance(this.b);
                if (!(instance.isAtLeastAComQuerySuccess() || UserEventModule.getInstance() == null || StrategyQueryModule.getInstance(this.b).getCommonQueryTime() == 0 || instance.getCurrentQueryStep() == 2)) {
                    instance.startQuery();
                }
            }
            if (!(state2 == null && state == null) && (NetworkInfo.State.CONNECTED == state || NetworkInfo.State.CONNECTED == state2)) {
                b.a().a(this.d);
            }
            this.c = false;
        } catch (Exception e) {
            com.tencent.beacon.core.d.b.a(e);
        }
    }

    public final void a(Context context) {
        if (context == null) {
            com.tencent.beacon.core.d.b.d("[net] Context is null!", new Object[0]);
        } else if (!this.a) {
            this.a = true;
            context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }
}
