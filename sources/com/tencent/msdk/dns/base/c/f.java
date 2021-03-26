package com.tencent.msdk.dns.base.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: NetworkChangeObservableImpl */
final class f extends a {
    f(Context context) {
        super(context);
        if (context != null) {
            final Context applicationContext = context.getApplicationContext();
            applicationContext.registerReceiver(new BroadcastReceiver() {
                /* class com.tencent.msdk.dns.base.c.f.AnonymousClass1 */

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    f.this.a(applicationContext);
                }
            }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }
}
