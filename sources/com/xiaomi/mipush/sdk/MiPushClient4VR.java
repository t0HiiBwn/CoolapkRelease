package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.gi;
import com.xiaomi.push.gs;
import com.xiaomi.push.gv;
import com.xiaomi.push.hi;
import com.xiaomi.push.service.o;

public class MiPushClient4VR {
    public static void uploadData(Context context, String str) {
        hi hiVar = new hi();
        hiVar.c(gs.VRUpload.S);
        hiVar.b(b.m54a(context).m55a());
        hiVar.d(context.getPackageName());
        hiVar.a("data", str);
        hiVar.a(o.a());
        aq.a(context).a((aq) hiVar, gi.Notification, (gv) null);
    }
}
