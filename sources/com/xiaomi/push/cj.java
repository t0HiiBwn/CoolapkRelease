package com.xiaomi.push;

import android.content.Context;
import android.content.IntentFilter;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.mpcd.receivers.BroadcastActionsReceiver;

public class cj {
    private static co a() {
        return new ck();
    }

    public static void a(Context context) {
        cp.a(context).a();
        try {
            context.registerReceiver(new BroadcastActionsReceiver(a()), b());
        } catch (Throwable th) {
            c.a(th);
        }
    }

    private static IntentFilter b() {
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
}
