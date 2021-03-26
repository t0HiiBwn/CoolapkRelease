package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.mipush.sdk.COSPushHelper;
import com.xiaomi.mipush.sdk.FTOSPushHelper;
import com.xiaomi.mipush.sdk.HWPushHelper;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.ab;
import com.xiaomi.mipush.sdk.ak;
import com.xiaomi.mipush.sdk.ap;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.bc;
import com.xiaomi.push.gn;
import com.xiaomi.push.service.be;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NetworkStatusReceiver extends BroadcastReceiver {
    private static int a = 1;

    /* renamed from: a  reason: collision with other field name */
    private static BlockingQueue<Runnable> f1033a = new LinkedBlockingQueue();

    /* renamed from: a  reason: collision with other field name */
    private static ThreadPoolExecutor f1034a = new ThreadPoolExecutor(a, b, (long) c, TimeUnit.SECONDS, f1033a);

    /* renamed from: a  reason: collision with other field name */
    private static boolean f1035a = false;
    private static int b = 1;
    private static int c = 2;

    /* renamed from: b  reason: collision with other field name */
    private boolean f1036b;

    public NetworkStatusReceiver() {
        this.f1036b = false;
        this.f1036b = true;
    }

    public NetworkStatusReceiver(Object obj) {
        this.f1036b = false;
        f1035a = true;
    }

    /* access modifiers changed from: private */
    public void a(Context context) {
        if (!ak.a(context).m68a() && b.m75a(context).m84c() && !b.m75a(context).m86e()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(context, "com.xiaomi.push.service.XMPushService"));
                intent.setAction("com.xiaomi.push.network_status_changed");
                be.a(context).m640a(intent);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        gn.m373a(context);
        if (bc.b(context) && ak.a(context).m71b()) {
            ak.a(context).m72c();
        }
        if (bc.b(context)) {
            if ("syncing".equals(ab.a(context).a(ap.DISABLE_PUSH))) {
                MiPushClient.disablePush(context);
            }
            if ("syncing".equals(ab.a(context).a(ap.ENABLE_PUSH))) {
                MiPushClient.enablePush(context);
            }
            if ("syncing".equals(ab.a(context).a(ap.UPLOAD_HUAWEI_TOKEN))) {
                MiPushClient.syncAssemblePushToken(context);
            }
            if ("syncing".equals(ab.a(context).a(ap.UPLOAD_FCM_TOKEN))) {
                MiPushClient.syncAssembleFCMPushToken(context);
            }
            if ("syncing".equals(ab.a(context).a(ap.UPLOAD_COS_TOKEN))) {
                MiPushClient.syncAssembleCOSPushToken(context);
            }
            if ("syncing".equals(ab.a(context).a(ap.UPLOAD_FTOS_TOKEN))) {
                MiPushClient.syncAssembleFTOSPushToken(context);
            }
            if (HWPushHelper.needConnect() && HWPushHelper.shouldTryConnect(context)) {
                HWPushHelper.setConnectTime(context);
                HWPushHelper.registerHuaWeiAssemblePush(context);
            }
            COSPushHelper.doInNetworkChange(context);
            FTOSPushHelper.doInNetworkChange(context);
        }
    }

    public static boolean a() {
        return f1035a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (!this.f1036b) {
            f1034a.execute(new a(this, context));
        }
    }
}
