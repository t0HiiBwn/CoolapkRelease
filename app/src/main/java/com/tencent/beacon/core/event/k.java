package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.b.d;
import com.tencent.beacon.core.c.i;
import com.tencent.beacon.core.c.j;
import com.tencent.beacon.core.d.a;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.d.c;
import com.tencent.beacon.core.d.h;
import com.tencent.beacon.core.protocol.event.EventRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RecordBeanParser */
public final class k {
    public static EventRecord a(RDBean rDBean) {
        Map<String, String> eMap;
        if (rDBean == null || !"UA".equals(rDBean.getTP()) || (eMap = rDBean.getEMap()) == null) {
            return null;
        }
        try {
            EventRecord eventRecord = new EventRecord();
            eventRecord.eventName = rDBean.getEN();
            eventRecord.eventTime = rDBean.getTM();
            eventRecord.apn = rDBean.getApn() != null ? rDBean.getApn() : eventRecord.apn;
            eventRecord.srcIp = rDBean.getSrcIp() != null ? rDBean.getSrcIp() : eventRecord.srcIp;
            eventRecord.cosumeTime = rDBean.getElapse();
            eventRecord.eventResult = rDBean.isEventResult();
            eventRecord.packageSize = rDBean.getSize();
            eventRecord.eventValue = a.a(eMap);
            return eventRecord;
        } catch (Throwable th) {
            b.a(th);
            b.d(th.getMessage(), new Object[0]);
            return null;
        }
    }

    public static RDBean a(Context context, String str, String str2, boolean z, long j, long j2, Map<String, String> map, boolean z2, boolean z3) {
        String a;
        if (str2 == null) {
            return null;
        }
        com.tencent.beacon.core.b.b a2 = com.tencent.beacon.core.b.b.a(o.a);
        if (a2 == null) {
            b.d("[event] BeaconInfo is null!", new Object[0]);
            return null;
        }
        String b = o.b(str);
        long a3 = h.a(a2.h());
        String g = a2.g();
        String c = c.c(context);
        if (c == null) {
            c = "null";
        }
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        boolean z4 = d.a().i() && !str2.startsWith("rqd_");
        d a4 = d.a(context);
        if (!z4) {
            hashMap.put("A1", b);
            String a5 = o.a();
            if (a5 != null && !a5.equals("")) {
                hashMap.put("QQ", a5);
            }
            hashMap.put("A2", a4.a());
            hashMap.put("A4", a4.c());
            hashMap.put("A6", a4.b());
            hashMap.put("A7", a4.d());
            hashMap.put("A3", a4.f());
            hashMap.put("A23", a2.a(str));
            hashMap.put("A31", a4.e());
            hashMap.put("A67", com.tencent.beacon.core.b.a.i(context));
            hashMap.put("A76", com.tencent.beacon.core.b.a.a());
            if (!hashMap.containsKey("A95")) {
                hashMap.put("A95", com.tencent.beacon.core.b.a.d(context));
            }
            hashMap.put("A99", z2 ? "Y" : "N");
        }
        ArrayList<j> c2 = i.a(context).c();
        if (!(c2 == null || c2.size() <= 0 || (a = c2.get(0).a()) == null)) {
            hashMap.put("A100", a);
        }
        if (!"".equals(a2.j())) {
            hashMap.put("A113", a2.j());
        }
        RDBean rDBean = new RDBean();
        rDBean.setEN(str2);
        rDBean.setTM(a3);
        rDBean.setTP("UA");
        rDBean.setEMap(hashMap);
        rDBean.setImmediatelyUpload(z3);
        rDBean.setApn(c);
        rDBean.setSrcIp(g);
        rDBean.setEventResult(z);
        rDBean.setElapse(j);
        rDBean.setSize(j2);
        return rDBean;
    }
}
