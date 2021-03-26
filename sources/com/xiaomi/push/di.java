package com.xiaomi.push;

import android.content.Context;
import android.content.IntentFilter;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.mpcd.receivers.BroadcastActionsReceiver;

public class di {
    private static IntentFilter a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_RESTARTED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        return intentFilter;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static dn m200a() {
        return new dj();
    }

    public static void a(Context context) {
        Cdo.a(context).m201a();
        try {
            context.registerReceiver(new BroadcastActionsReceiver(m200a()), a());
        } catch (Throwable th) {
            b.a(th);
        }
    }
}
