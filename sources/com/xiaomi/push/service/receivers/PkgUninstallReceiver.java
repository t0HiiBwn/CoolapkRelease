package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.be;

public class PkgUninstallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && "android.intent.action.PACKAGE_REMOVED".equals(intent.getAction())) {
            boolean z = intent.getExtras().getBoolean("android.intent.extra.REPLACING");
            Uri data = intent.getData();
            if (data != null && !z) {
                try {
                    Intent intent2 = new Intent(context, XMPushService.class);
                    intent2.setAction(ba.a);
                    intent2.putExtra("uninstall_pkg_name", data.getEncodedSchemeSpecificPart());
                    be.a(context).m640a(intent2);
                } catch (Exception e) {
                    b.a(e);
                }
            }
        }
    }
}
