package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class aq extends k {
    private static Map<String, String> i;
    public long a = 0;
    public byte b = 0;
    public String c = "";
    public String d = "";
    public String e = "";
    public Map<String, String> f = null;
    public boolean g = true;
    private String h = "";

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.a, 0);
        jVar.a(this.b, 1);
        String str = this.c;
        if (str != null) {
            jVar.a(str, 2);
        }
        String str2 = this.d;
        if (str2 != null) {
            jVar.a(str2, 3);
        }
        String str3 = this.e;
        if (str3 != null) {
            jVar.a(str3, 4);
        }
        Map<String, String> map = this.f;
        if (map != null) {
            jVar.a((Map) map, 5);
        }
        String str4 = this.h;
        if (str4 != null) {
            jVar.a(str4, 6);
        }
        jVar.a(this.g, 7);
    }

    static {
        HashMap hashMap = new HashMap();
        i = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.a = iVar.a(this.a, 0, true);
        this.b = iVar.a(this.b, 1, true);
        this.c = iVar.b(2, false);
        this.d = iVar.b(3, false);
        this.e = iVar.b(4, false);
        this.f = (Map) iVar.a((i) i, 5, false);
        this.h = iVar.b(6, false);
        this.g = iVar.a(7, false);
    }
}
