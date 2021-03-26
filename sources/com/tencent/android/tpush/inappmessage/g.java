package com.tencent.android.tpush.inappmessage;

import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.service.protocol.j;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.util.Util;

/* compiled from: ProGuard */
public class g {
    private static Context a;

    /* compiled from: ProGuard */
    public static class a {
        public static g a = new g();
    }

    public static g a(Context context) {
        if (a == null) {
            a = context.getApplicationContext();
        }
        return a.a;
    }

    public void a(j jVar) {
        try {
            String str = jVar.y;
            if (Util.isNullOrEmptyString(str)) {
                return;
            }
            if (a != null) {
                b(jVar);
                Intent intent = new Intent();
                intent.setClass(a, InAppMessageActivity.class);
                intent.putExtra("inAppMsg", str);
                intent.putExtra("group_id", jVar.r);
                intent.putExtra("msgId", jVar.a);
                intent.putExtra("type", jVar.f);
                intent.putExtra("pushChannel", jVar.m);
                intent.putExtra("server_time", jVar.k);
                intent.putExtra("targetType", jVar.t);
                intent.putExtra("source", jVar.u);
                intent.putExtra("timestamps", jVar.h);
                intent.putExtra("inapp_protect", Rijndael.encrypt("" + (System.currentTimeMillis() - 1000)));
                intent.addFlags(268435456);
                a.startActivity(intent);
            }
        } catch (Throwable th) {
            TLogger.e("InAppMessageManager", "InAppMsg parseInAppMsgConfig :" + th.toString());
        }
    }

    private void b(j jVar) {
        Intent intent = new Intent();
        intent.putExtra("group_id", jVar.r);
        intent.putExtra("msgId", jVar.a);
        intent.putExtra("type", jVar.f);
        intent.putExtra("pushChannel", 100);
        intent.putExtra("server_time", jVar.k);
        intent.putExtra("targetType", jVar.t);
        intent.putExtra("source", jVar.u);
        intent.putExtra("timestamps", jVar.h);
        ServiceStat.appReportServiceReceived(b.e(), intent);
    }
}
