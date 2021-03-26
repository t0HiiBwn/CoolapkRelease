package com.huawei.hms.stats;

import java.util.List;
import java.util.Map;

public class ar implements av {
    private byte[] a;
    private String b;
    private String c;
    private String d;
    private String e;
    private List<w> f;

    public ar(byte[] bArr, String str, String str2, String str3, String str4, List<w> list) {
        this.a = (byte[]) bArr.clone();
        this.b = str;
        this.c = str2;
        this.e = str3;
        this.d = str4;
        this.f = list;
    }

    private aj a(Map<String, String> map) {
        return ai.a(this.b, this.a, map);
    }

    private Map<String, String> a() {
        return bk.c(this.c, this.e, this.d);
    }

    private void b() {
        aw.a().a(new au(this.f, this.c, this.d, this.e));
    }

    @Override // java.lang.Runnable
    public void run() {
        af.b("DataSendTask", "send data running");
        int a2 = a(a()).a();
        if (a2 != 200) {
            b();
            return;
        }
        af.a("DataSendTask", "events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + this.d, this.e, this.c, Integer.valueOf(a2));
    }
}
