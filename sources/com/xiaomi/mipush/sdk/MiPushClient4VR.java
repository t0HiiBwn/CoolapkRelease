package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hc;
import com.xiaomi.push.hm;
import com.xiaomi.push.hp;
import com.xiaomi.push.ib;
import com.xiaomi.push.service.aq;

public class MiPushClient4VR {
    public static void uploadData(Context context, String str) {
        ib ibVar = new ib();
        ibVar.c(hm.VRUpload.f576a);
        ibVar.b(b.m75a(context).m76a());
        ibVar.d(context.getPackageName());
        ibVar.a("data", str);
        ibVar.a(aq.a());
        ak.a(context).a((ak) ibVar, hc.Notification, (hp) null);
    }
}
