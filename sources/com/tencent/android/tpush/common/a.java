package com.tencent.android.tpush.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;

/* compiled from: ProGuard */
public class a {
    private static volatile b a;

    public static void a(Context context) {
        try {
            if (a == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = new b();
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addDataScheme("package");
                        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                        d.a(context, a, intentFilter);
                    }
                }
            }
        } catch (Throwable th) {
            TLogger.e("AppChangesHandler", "AppChangesHandler setupHandler error", th);
        }
    }

    /* compiled from: ProGuard */
    private static class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && context != null) {
                CommonWorkingThread.getInstance().execute(new RunnableC0131a(context, intent));
            }
        }
    }

    /* renamed from: com.tencent.android.tpush.common.a$a  reason: collision with other inner class name */
    /* compiled from: ProGuard */
    private static class RunnableC0131a implements Runnable {
        private Context a = null;
        private Intent b = null;

        public RunnableC0131a(Context context, Intent intent) {
            this.a = context;
            this.b = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            String action = this.b.getAction();
            if (action != null) {
                if ("android.intent.action.PACKAGE_ADDED".equals(action) || "android.intent.action.PACKAGE_REPLACED".equals(action) || "android.intent.action.PACKAGE_REMOVED".equals(action)) {
                    TLogger.d("AppChangesHandler", "action:" + action);
                }
            }
        }
    }
}
