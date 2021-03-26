package com.xiaomi.mipush.sdk;

import com.xiaomi.push.gn;
import java.util.HashMap;

public class k {
    private static HashMap<d, a> a = new HashMap<>();

    static class a {
        public String a;
        public String b;

        public a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    static {
        a(d.ASSEMBLE_PUSH_HUAWEI, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_FCM, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_COS, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        a(d.ASSEMBLE_PUSH_FTOS, new a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    public static av a(d dVar) {
        int i = l.a[dVar.ordinal()];
        if (i == 1) {
            return av.UPLOAD_HUAWEI_TOKEN;
        }
        if (i == 2) {
            return av.UPLOAD_FCM_TOKEN;
        }
        if (i == 3) {
            return av.UPLOAD_COS_TOKEN;
        }
        if (i != 4) {
            return null;
        }
        return av.UPLOAD_FTOS_TOKEN;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static a m75a(d dVar) {
        return a.get(dVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static gn m76a(d dVar) {
        return gn.AggregatePushSwitch;
    }

    private static void a(d dVar, a aVar) {
        if (aVar != null) {
            a.put(dVar, aVar);
        }
    }
}
