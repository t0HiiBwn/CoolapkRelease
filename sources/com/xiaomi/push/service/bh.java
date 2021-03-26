package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.gi;
import com.xiaomi.push.gv;
import com.xiaomi.push.hf;
import com.xiaomi.push.hi;
import com.xiaomi.push.ht;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bh extends XMPushService.i {
    final /* synthetic */ String a;
    final /* synthetic */ List b;
    final /* synthetic */ String c;
    final /* synthetic */ bg d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    bh(bg bgVar, int i, String str, List list, String str2) {
        super(i);
        this.d = bgVar;
        this.a = str;
        this.b = list;
        this.c = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        String str = this.d.a(this.a);
        ArrayList<hi> a2 = ak.a(this.b, this.a, str, 32768);
        if (a2 != null) {
            Iterator<hi> it2 = a2.iterator();
            while (it2.hasNext()) {
                hi next = it2.next();
                next.a("uploadWay", "longXMPushService");
                hf a3 = bu.a(this.a, str, next, gi.Notification);
                if (!TextUtils.isEmpty(this.c) && !TextUtils.equals(this.a, this.c)) {
                    if (a3.m() == null) {
                        gv gvVar = new gv();
                        gvVar.a("-1");
                        a3.a(gvVar);
                    }
                    a3.m().b("ext_traffic_source_pkg", this.c);
                }
                this.d.a.a(this.a, ht.a(a3), true);
            }
            return;
        }
        c.d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String b() {
        return "Send tiny data.";
    }
}
