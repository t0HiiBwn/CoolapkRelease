package com.tencent.android.tpush.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: ProGuard */
public class c {
    private static int a;
    private static int b;
    private static Handler c;
    private static ReentrantLock d = new ReentrantLock();

    /* compiled from: ProGuard */
    private static class a extends Handler {
        private Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.a == null) {
                super.handleMessage(message);
                return;
            }
            int i = message.what;
            if (i != 1) {
                if (i == 2) {
                    c.i(this.a, message.arg1);
                }
                super.handleMessage(message);
                return;
            }
            if (c.b > 0) {
                c.b--;
            }
            if (c.b == 0) {
                c.h(this.a, c.a);
                int unused = c.a = 0;
                c.c.removeCallbacks(null);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void h(final Context context, final int i) {
        if (ChannelUtils.isBrandHuaWei() || ChannelUtils.isBrandHonor()) {
            CommonWorkingThread.getInstance().execute(new Runnable() {
                /* class com.tencent.android.tpush.common.c.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    String str = "";
                    try {
                        if (ChannelUtils.isBrandHuaWei()) {
                            str = "content://com.huawei.android.launcher.settings/badge/";
                        } else if (ChannelUtils.isBrandHonor()) {
                            str = "content://com.hihonor.android.launcher.settings/badge/";
                        }
                        TLogger.i("BadgeUtils", "change huawei badge " + i);
                        Bundle bundle = new Bundle();
                        bundle.putString("package", context.getPackageName());
                        bundle.putString("class", j.p(context));
                        Bundle call = context.getContentResolver().call(Uri.parse(str), "getbadgeNumber", (String) null, bundle);
                        int i = 0;
                        int i2 = (call != null ? call.getInt("badgenumber", 0) : 0) + i;
                        if (i2 >= 0) {
                            i = i2;
                        }
                        bundle.putInt("badgenumber", i);
                        context.getContentResolver().call(Uri.parse(str), "change_badge", (String) null, bundle);
                    } catch (Throwable th) {
                        TLogger.w("BadgeUtils", "change huawei badge error: " + th.toString());
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void i(final Context context, final int i) {
        if (ChannelUtils.isBrandHuaWei() || ChannelUtils.isBrandHonor()) {
            CommonWorkingThread.getInstance().execute(new Runnable() {
                /* class com.tencent.android.tpush.common.c.AnonymousClass2 */

                @Override // java.lang.Runnable
                public void run() {
                    String str = "";
                    try {
                        if (ChannelUtils.isBrandHuaWei()) {
                            str = "content://com.huawei.android.launcher.settings/badge/";
                        } else if (ChannelUtils.isBrandHonor()) {
                            str = "content://com.hihonor.android.launcher.settings/badge/";
                        }
                        TLogger.i("BadgeUtils", "set huawei badge " + i);
                        Bundle bundle = new Bundle();
                        bundle.putString("package", context.getPackageName());
                        bundle.putString("class", j.p(context));
                        bundle.putInt("badgenumber", i);
                        context.getContentResolver().call(Uri.parse(str), "change_badge", (String) null, bundle);
                    } catch (Throwable th) {
                        TLogger.w("BadgeUtils", "set huawei badge error: " + th.toString());
                    }
                }
            });
        }
    }

    public static void a(Context context) {
        b(context, 0);
    }

    public static void a(Context context, int i) {
        StringBuilder sb;
        Throwable th;
        if (ChannelUtils.isBrandHuaWei() || ChannelUtils.isBrandHonor()) {
            try {
                d.lock();
                if (c == null) {
                    c = new a(context.getApplicationContext());
                }
                b++;
                a += i;
                Message message = new Message();
                message.what = 1;
                c.sendMessageDelayed(message, 200);
                try {
                    d.unlock();
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    sb = new StringBuilder();
                }
            } catch (Throwable th3) {
                th = th3;
                sb = new StringBuilder();
            }
        } else {
            return;
        }
        sb.append("change huawei badge unlock error: ");
        sb.append(th.toString());
        TLogger.e("BadgeUtils", sb.toString());
    }

    public static void b(Context context, int i) {
        if (ChannelUtils.isBrandHuaWei() || ChannelUtils.isBrandHonor()) {
            try {
                if (c == null) {
                    c = new a(context.getApplicationContext());
                }
                Message message = new Message();
                message.what = 2;
                message.arg1 = i;
                c.sendMessage(message);
            } catch (Throwable th) {
                TLogger.w("BadgeUtils", "set huawei badge error: " + th.toString());
            }
        }
    }

    public static void c(Context context, int i) {
        if (i >= 0) {
            b(context, i);
            e(context, i);
            d(context, i);
        }
    }

    public static void b(Context context) {
        b(context, 0);
        d(context, 0);
        e(context, 0);
    }

    public static void d(final Context context, final int i) {
        String b2 = j.b();
        if (!TextUtils.isEmpty(b2) && "oppo".equals(b2)) {
            CommonWorkingThread.getInstance().execute(new Runnable() {
                /* class com.tencent.android.tpush.common.c.AnonymousClass3 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        TLogger.i("BadgeUtils", "set oppo badge " + i);
                        Bundle bundle = new Bundle();
                        bundle.putInt("app_badge_count", i);
                        context.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (String) null, bundle);
                    } catch (Throwable th) {
                        TLogger.w("BadgeUtils", "set oppo badge error" + th.toString());
                    }
                }
            });
        }
    }

    public static void e(final Context context, final int i) {
        String b2 = j.b();
        if (!TextUtils.isEmpty(b2) && "vivo".equals(b2)) {
            CommonWorkingThread.getInstance().execute(new Runnable() {
                /* class com.tencent.android.tpush.common.c.AnonymousClass4 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        TLogger.i("BadgeUtils", "set vivo badge " + i);
                        Intent intent = new Intent();
                        intent.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
                        intent.putExtra("packageName", context.getPackageName());
                        intent.putExtra("className", j.p(context));
                        intent.putExtra("notificationNum", i);
                        intent.addFlags(16777216);
                        context.sendBroadcast(intent);
                    } catch (Throwable th) {
                        TLogger.w("BadgeUtils", "set vivo badge error: " + th.toString());
                    }
                }
            });
        }
    }
}
