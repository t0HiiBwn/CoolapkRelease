package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class ap extends k implements Cloneable {
    private static ao m = new ao();
    private static Map<String, String> n = null;
    private static /* synthetic */ boolean o = true;
    public boolean a = true;
    public boolean b = true;
    public boolean c = true;
    public String d = "";
    public String e = "";
    public ao f = null;
    public Map<String, String> g = null;
    public long h = 0;
    public int i = 0;
    private String j = "";
    private String k = "";

    /* renamed from: l  reason: collision with root package name */
    private int f1441l = 0;

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        ap apVar = (ap) obj;
        if (!l.a(this.a, apVar.a) || !l.a(this.b, apVar.b) || !l.a(this.c, apVar.c) || !l.a(this.d, apVar.d) || !l.a(this.e, apVar.e) || !l.a(this.f, apVar.f) || !l.a(this.g, apVar.g) || !l.a(this.h, apVar.h) || !l.a(this.j, apVar.j) || !l.a(this.k, apVar.k) || !l.a(this.f1441l, apVar.f1441l) || !l.a(this.i, apVar.i)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // java.lang.Object
    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (o) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(j jVar) {
        jVar.a(this.a, 0);
        jVar.a(this.b, 1);
        jVar.a(this.c, 2);
        String str = this.d;
        if (str != null) {
            jVar.a(str, 3);
        }
        String str2 = this.e;
        if (str2 != null) {
            jVar.a(str2, 4);
        }
        ao aoVar = this.f;
        if (aoVar != null) {
            jVar.a((k) aoVar, 5);
        }
        Map<String, String> map = this.g;
        if (map != null) {
            jVar.a((Map) map, 6);
        }
        jVar.a(this.h, 7);
        String str3 = this.j;
        if (str3 != null) {
            jVar.a(str3, 8);
        }
        String str4 = this.k;
        if (str4 != null) {
            jVar.a(str4, 9);
        }
        jVar.a(this.f1441l, 10);
        jVar.a(this.i, 11);
    }

    static {
        HashMap hashMap = new HashMap();
        n = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(i iVar) {
        this.a = iVar.a(0, true);
        this.b = iVar.a(1, true);
        this.c = iVar.a(2, true);
        this.d = iVar.b(3, false);
        this.e = iVar.b(4, false);
        this.f = (ao) iVar.a((k) m, 5, false);
        this.g = (Map) iVar.a((i) n, 6, false);
        this.h = iVar.a(this.h, 7, false);
        this.j = iVar.b(8, false);
        this.k = iVar.b(9, false);
        this.f1441l = iVar.a(this.f1441l, 10, false);
        this.i = iVar.a(this.i, 11, false);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(StringBuilder sb, int i2) {
        h hVar = new h(sb, i2);
        hVar.a(this.a, "enable");
        hVar.a(this.b, "enableUserInfo");
        hVar.a(this.c, "enableQuery");
        hVar.a(this.d, "url");
        hVar.a(this.e, "expUrl");
        hVar.a((k) this.f, "security");
        hVar.a((Map) this.g, "valueMap");
        hVar.a(this.h, "strategylastUpdateTime");
        hVar.a(this.j, "httpsUrl");
        hVar.a(this.k, "httpsExpUrl");
        hVar.a(this.f1441l, "eventRecordCount");
        hVar.a(this.i, "eventTimeInterval");
    }
}
