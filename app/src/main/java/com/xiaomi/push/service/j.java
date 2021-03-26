package com.xiaomi.push.service;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.hc;
import com.xiaomi.push.hp;
import com.xiaomi.push.hy;
import com.xiaomi.push.ib;
import com.xiaomi.push.im;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class j extends XMPushService.i {
    final /* synthetic */ i a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f1022a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ List f1023a;
    final /* synthetic */ String b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    j(i iVar, int i, String str, List list, String str2) {
        super(i);
        this.a = iVar;
        this.f1022a = str;
        this.f1023a = list;
        this.b = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a */
    public String mo344a() {
        return "Send tiny data.";
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    /* renamed from: a  reason: collision with other method in class */
    public void mo659a() {
        String str = this.a.a(this.f1022a);
        ArrayList<ib> a2 = bl.a(this.f1023a, this.f1022a, str, 32768);
        if (a2 != null) {
            Iterator<ib> it2 = a2.iterator();
            while (it2.hasNext()) {
                ib next = it2.next();
                next.a("uploadWay", "longXMPushService");
                hy a3 = x.a(this.f1022a, str, next, hc.Notification);
                if (!TextUtils.isEmpty(this.b) && !TextUtils.equals(this.f1022a, this.b)) {
                    if (a3.m456a() == null) {
                        hp hpVar = new hp();
                        hpVar.a("-1");
                        a3.a(hpVar);
                    }
                    a3.m456a().b("ext_traffic_source_pkg", this.b);
                }
                this.a.a.a(this.f1022a, im.a(a3), true);
            }
            return;
        }
        b.d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
    }
}
