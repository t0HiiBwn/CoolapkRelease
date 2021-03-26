package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.es;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.aw;
import com.xiaomi.push.service.be;

public class PingReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        b.c(intent.getPackage() + " is the package name");
        if (!aw.o.equals(intent.getAction())) {
            b.m41a("cancel the old ping timer");
            es.a();
        } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
            b.c("Ping XMChannelService on timer");
            try {
                Intent intent2 = new Intent(context, XMPushService.class);
                intent2.putExtra("time_stamp", System.currentTimeMillis());
                intent2.setAction("com.xiaomi.push.timer");
                be.a(context).m640a(intent2);
            } catch (Exception e) {
                b.a(e);
            }
        }
    }
}
